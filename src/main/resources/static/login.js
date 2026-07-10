const loginForm = document.querySelector('#login-form');
const loginAPI = "http://localhost:8084/login"; 

if (loginForm) {
    loginForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const username = document.querySelector('#username').value.trim();
        const password = document.querySelector('#password').value.trim();
        
        document.querySelector('#username-error').innerText = '';
        document.querySelector('#password-error').innerText = '';

        let isValid = true;

        if (!username) {
            document.querySelector('#username-error').innerText = 'Tài khoản không được để trống';
            isValid = false;
        }
        if (!password) {
            document.querySelector('#password-error').innerText = 'Mật khẩu không được để trống';
            isValid = false;
        }

        if (isValid) {
            const formData = new URLSearchParams();
            formData.append('username', username);
            formData.append('password', password);

            fetch(loginAPI, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: formData.toString()
            })
            .then(response => {
                if (response.redirected) {
                    if (response.url.includes('error')) {
                        throw new Error('Tài khoản hoặc mật khẩu không chính xác!');
                    }
                    // Đăng nhập thành công -> Lưu trạng thái vào trình duyệt
                    localStorage.setItem("isLoggedIn", "true");
                    window.location.href = response.url;
                } else {
                    if (response.status === 401 || response.status === 403) {
                        throw new Error('Tài khoản hoặc mật khẩu không chính xác!');
                    }
                }
            })
            .catch(error => {
                console.error('Lỗi:', error);
                alert(error.message || 'Có lỗi hệ thống xảy ra khi đăng nhập.');
            });
        }
    });
}