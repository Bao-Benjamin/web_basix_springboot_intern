const registerForm = document.querySelector('#register-form');
const registerAPI = "http://localhost:8084/api/register"; // Thay endpoint auth thật của bạn ở đây

registerForm.addEventListener('submit', function(event) {
    event.preventDefault(); // Chặn hành vi load lại trang của form

    // Lấy giá trị đầu vào
    const username = document.querySelector('#username').value.trim();
    const password = document.querySelector('#password').value.trim();
    const confirmPassword = document.querySelector('#confirm-password').value.trim();

    // Reset các thông báo lỗi cũ
    document.querySelector('#username-error').innerText = '';
    document.querySelector('#password-error').innerText = '';
    document.querySelector('#confirm-password-error').innerText = '';

    let isValid = true;

    // 1. Validate dữ liệu cơ bản ở Client
    if (!username) {
        document.querySelector('#username-error').innerText = 'Tài khoản không được để trống';
        isValid = false;
    }
    if (!password) {
        document.querySelector('#password-error').innerText = 'Mật khẩu không được để trống';
        isValid = false;
    } else if (password.length < 6) {
        document.querySelector('#password-error').innerText = 'Mật khẩu phải từ 6 ký tự trở lên';
        isValid = false;
    }
    if (password !== confirmPassword) {
        document.querySelector('#confirm-password-error').innerText = 'Mật khẩu nhập lại không khớp';
        isValid = false;
    }

    // Nếu dữ liệu hợp lệ thì bắt đầu gọi API bằng FETCH POST
    if (isValid) {
        const payload = {
            username: username,
            password: password
        };

        fetch(registerAPI, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(payload)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Đăng ký thất bại hoặc tài khoản đã tồn tại.');
            }
            return response.json();
        })
        .then(data => {
            alert('Đăng ký tài khoản thành công!');
            window.location.href = './index.html'; // Chuyển hướng về trang chủ sau khi thành công
        })
        .catch(error => {
            console.error('Lỗi:', error);
            alert(error.message || 'Có lỗi hệ thống xảy ra.');
        });
    }
});