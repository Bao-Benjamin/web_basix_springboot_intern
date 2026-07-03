// 1. Khởi tạo mảng dữ liệu ban đầu với ít nhất 20 cây cảnh
let plants = JSON.parse(localStorage.getItem("plants")) || [
  { id: 1, name: "Sen đá", category: "Cây trong nhà", price: 85000, date: "2026-01-10", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1611735341450-74d61e660ad2?w=400&q=80" },
  { id: 2, name: "Trầu bà", category: "Cây trong nhà", price: 120000, date: "2026-02-15", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1593691509543-c55fb32d8de5?w=400&q=80" },
  { id: 3, name: "Hoa hồng", category: "Cây ngoài trời", price: 250000, date: "2026-03-03", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1525310072745-f49212b5ac6d?w=400&q=80" },
  { id: 4, name: "Xoài cát Hòa Lộc", category: "Cây ăn quả", price: 450000, date: "2026-04-01", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1601493700631-2b16ec4b4716?w=400&q=80" },
  { id: 5, name: "Xương rồng", category: "Cây ngoài trời", price: 60000, date: "2026-05-20", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1416879595882-3373a0480b5b?w=400&q=80" },
  { id: 6, name: "Lưỡi hổ", category: "Cây trong nhà", price: 140000, date: "2026-01-12", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1596547609652-9cf5d8d76921?w=400&q=80" },
  { id: 7, name: "Kim tiền", category: "Cây trong nhà", price: 180000, date: "2026-02-18", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1614594975525-e45190c55d0b?w=400&q=80" },
  { id: 8, name: "Lan Ý", category: "Cây trong nhà", price: 135000, date: "2026-02-25", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1599599810769-bcde5a160d32?w=400&q=80" },
  { id: 9, name: "Cây Bàng Singapore", category: "Cây trong nhà", price: 320000, date: "2026-03-10", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1597055181300-e3633a207518?w=400&q=80" },
  { id: 10, name: "Hoa mười giờ", category: "Cây ngoài trời", price: 30000, date: "2026-04-05", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1516245834210-c4c142787335?w=400&q=80" },
  { id: 11, name: "Cây khế cảnh", category: "Cây ăn quả", price: 600000, date: "2026-05-15", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1601493700631-2b16ec4b4716?w=400&q=80" },
  { id: 12, name: "Ổi Mỹ mini", category: "Cây ăn quả", price: 350000, date: "2026-06-01", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1601493700631-2b16ec4b4716?w=400&q=80" },
  { id: 13, name: "Cây lựu lùn", category: "Cây ăn quả", price: 500000, date: "2026-03-20", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1601493700631-2b16ec4b4716?w=400&q=80" },
  { id: 14, name: "Cây tùng la hán", category: "Cây ngoài trời", price: 1200000, date: "2026-01-05", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1416879595882-3373a0480b5b?w=400&q=80" },
  { id: 15, name: "Cây hoa giấy", category: "Cây ngoài trời", price: 280000, date: "2026-02-28", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1525310072745-f49212b5ac6d?w=400&q=80" },
  { id: 16, name: "Cây vạn lộc", category: "Cây trong nhà", price: 95000, date: "2026-04-12", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1614594975525-e45190c55d0b?w=400&q=80" },
  { id: 17, name: "Cây hạnh phúc", category: "Cây trong nhà", price: 220000, date: "2026-05-02", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1597055181300-e3633a207518?w=400&q=80" },
  { id: 18, name: "Cây phong ba", category: "Cây ngoài trời", price: 400000, date: "2026-06-10", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1416879595882-3373a0480b5b?w=400&q=80" },
  { id: 19, name: "Cây chanh vàng", category: "Cây ăn quả", price: 190000, date: "2026-05-22", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1601493700631-2b16ec4b4716?w=400&q=80" },
  { id: 20, name: "Cây tía tô cảnh", category: "Cây ngoài trời", price: 45000, date: "2026-03-15", description: "Loại cây nhỏ dễ chăm sóc", img: "https://images.unsplash.com/photo-1516245834210-c4c142787335?w=400&q=80" }
];

// 2. State quản lý ứng dụng
let currentView = 'grid'; // 'grid' hoặc 'table'
let currentCategory = 'all';
let searchQuery = '';
let currentSort = 'name-asc';
let currentPage = 1;
const itemsPerPage = 5;

// DOM Elements
const searchInput = document.getElementById('search-input');
const sortSelect = document.getElementById('sort-select');
const viewTableBtn = document.getElementById('view-table-btn');
const viewGridBtn = document.getElementById('view-grid-btn');
const tableWrap = document.getElementById('table-wrap');
const gridContainer = document.getElementById('grid-container');
const tableBody = document.getElementById('table-body');
const filterPills = document.getElementById('filter-pills');
const paginationContainer = document.getElementById('khu-phan-trang');

const detailModal = document.getElementById('detail-modal');
const modalImage = document.getElementById('modal-image');
const modalName = document.getElementById('modal-name');
const modalCategory = document.getElementById('modal-category');
const modalPrice = document.getElementById('modal-price');
const modalDate = document.getElementById('modal-date');
const modalDescription = document.getElementById('modal-description');
const closeModalBtn = document.getElementById('close-modal');

const formModal = document.getElementById("form-modal");
const plantForm = document.getElementById("plant-form");
const formTitle = document.getElementById("form-title");
const plantId = document.getElementById("plant-id");
const plantName = document.getElementById("plant-name");
const plantCategory = document.getElementById("plant-category");
const plantPrice = document.getElementById("plant-price");
const plantDate = document.getElementById("plant-date");
const plantDescription = document.getElementById("plant-description");
const plantImg = document.getElementById("plant-img");
const addBtn = document.querySelector(".btn-primary");
const closeFormModalBtn = document.getElementById("close-form-modal");
const cancelFormBtn = document.getElementById("cancel-form");

// --- CÁC HÀM BỔ TRỢ ---
function saveToLocalStorage() {
  localStorage.setItem("plants", JSON.stringify(plants));
}

function openDetailModal(plant) {
  modalImage.src = plant.img || "";
  modalImage.alt = plant.name;
  modalName.textContent = plant.name;
  modalCategory.textContent = plant.category;
  modalPrice.textContent = plant.price.toLocaleString() + " VNĐ";
  modalDate.textContent = formatDate(plant.date);
  modalDescription.textContent = plant.description || "Không có mô tả";
  detailModal.style.display = "flex";
}

function closeDetailModal() {
  detailModal.style.display = "none";
}

function closeFormModal() {
  formModal.style.display = "none";
}

function getBadgeClass(cat) {
  if (cat === "Cây trong nhà") return "badge-indoor";
  if (cat === "Cây ngoài trời") return "badge-outdoor";
  return "badge-fruit";
}

function formatDate(dateStr) {
  if (!dateStr) return "";
  const d = new Date(dateStr);
  return `${String(d.getDate()).padStart(2, '0')}/${String(d.getMonth() + 1).padStart(2, '0')}/${d.getFullYear()}`;
}

function validateForm() {
  let valid = true;
  document.querySelectorAll(".form-error").forEach(e => e.textContent = "");

  if (plantName.value.trim() === "") {
    document.getElementById("name-error").textContent = "Tên không được để trống";
    valid = false;
  }
  if (Number(plantPrice.value) <= 0) {
    document.getElementById("price-error").textContent = "Giá phải lớn hơn 0";
    valid = false;
  }
  if (plantDate.value === "") {
    document.getElementById("date-error").textContent = "Ngày trồng bắt buộc";
    valid = false;
  }
  return valid;
}

// Hàm chuyển đổi trang toàn cục
window.changePage = function (page) {
  currentPage = page;
  render();
};

// --- HÀM RENDER CHÍNH ---
function render() {
  // LỌC DỮ LIỆU
  let filtered = plants.filter(plant => {
    const matchCategory = currentCategory === 'all' || plant.category === currentCategory;
    const matchSearch = plant.name.toLowerCase().includes(searchQuery.toLowerCase()) ||
                        plant.category.toLowerCase().includes(searchQuery.toLowerCase());
    return matchCategory && matchSearch;
  });

  // SẮP XẾP
  filtered.sort((a, b) => {
    if (currentSort === 'name-asc') return a.name.localeCompare(b.name, 'vi');
    if (currentSort === 'name-desc') return b.name.localeCompare(a.name, 'vi');
    if (currentSort === 'price-asc') return a.price - b.price;
    if (currentSort === 'price-desc') return b.price - a.price;
    if (currentSort === 'date-desc') return new Date(b.date) - new Date(a.date);
    if (currentSort === 'date-asc') return new Date(a.date) - new Date(b.date);
    return 0;
  });

  // PHÂN TRANG
  const totalItems = filtered.length;
  const totalPages = Math.ceil(totalItems / itemsPerPage) || 1;
  if (currentPage > totalPages) currentPage = totalPages;

  const startIndex = (currentPage - 1) * itemsPerPage;
  const paginatedItems = filtered.slice(startIndex, startIndex + itemsPerPage);

  // HIỂN THỊ VIEW GIAO DIỆN
  if (currentView === 'table') {
    tableWrap.style.display = 'block';
    gridContainer.style.display = 'none';

    tableBody.innerHTML = paginatedItems.map((plant, index) => `
      <tr>
        <td>${startIndex + index + 1}</td>
        <td><span class="plant-name" data-id="${plant.id}">${plant.name}</span></td>
        <td><span class="badge ${getBadgeClass(plant.category)}">${plant.category}</span></td>
        <td>${plant.price.toLocaleString()}</td>
        <td>${formatDate(plant.date)}</td>
        <td class="actions">
          <button class="btn btn-sm btn-outline edit-btn" data-id="${plant.id}">✏️ Sửa</button>
          <button class="btn btn-sm btn-danger delete-btn" data-id="${plant.id}">🗑️ Xóa</button>
        </td>
      </tr>
    `).join('');
  } else {
    tableWrap.style.display = 'none';
    gridContainer.style.display = 'grid';

    gridContainer.innerHTML = paginatedItems.map(plant => `
      <div class="plant-card" data-id="${plant.id}">
        <img class="card-img" src="${plant.img}" alt="${plant.name}" />
        <div class="card-body">
          <div class="card-name">${plant.name}</div>
          <span class="badge ${getBadgeClass(plant.category)}">${plant.category}</span>
          <div class="card-price">${plant.price.toLocaleString()} VNĐ</div>
          <div class="card-date">🗓 ${formatDate(plant.date)}</div>
          <div class="actions" style="margin-top:.75rem;">
            <button class="btn btn-sm btn-outline edit-btn" data-id="${plant.id}">✏️ Sửa</button>
            <button class="btn btn-sm btn-danger delete-btn" data-id="${plant.id}">🗑️ Xóa</button>
          </div>
        </div>
      </div>
    `).join('');
  }

  // RENDER THANH PHÂN TRANG
  let paginationHTML = `<button ${currentPage === 1 ? 'disabled' : ''} onclick="changePage(${currentPage - 1})">← Prev</button>`;
  for (let i = 1; i <= totalPages; i++) {
    paginationHTML += `<button class="${currentPage === i ? 'active' : ''}" onclick="changePage(${i})">${i}</button>`;
  }
  paginationHTML += `<button ${currentPage === totalPages ? 'disabled' : ''} onclick="changePage(${currentPage + 1})">Next →</button>`;
  paginationHTML += `<span class="page-info">Trang ${currentPage} / ${totalPages} · Tổng ${totalItems} cây</span>`;

  paginationContainer.innerHTML = paginationHTML;
}

// --- LẮNG NGHE SỰ KIỆN (EVENT LISTENERS) --- Nhóm ra ngoài render()

// Sự kiện click mở Modal chi tiết (Ủy quyền sự kiện để tối ưu)
document.addEventListener("click", (e) => {
  const targetName = e.target.closest(".plant-name");
  const targetCard = e.target.closest(".plant-card");
  
  // Nếu nhấn trúng nút Sửa hoặc Xóa thì dừng lại không mở chi tiết
  if (e.target.classList.contains("edit-btn") || e.target.classList.contains("delete-btn")) {
    return;
  }

  const element = targetName || targetCard;
  if (element) {
    const id = Number(element.dataset.id);
    const plant = plants.find(p => p.id === id);
    if (plant) openDetailModal(plant);
  }
});

// Sự kiện click nút Thêm cây mới
if (addBtn) {
  addBtn.addEventListener("click", () => {
    formTitle.textContent = "Thêm cây";
    plantForm.reset();
    plantId.value = "";
    formModal.style.display = "flex";
  });
}

// Sự kiện Submit Form (Thêm / Sửa)
plantForm.addEventListener("submit", (e) => {
  e.preventDefault();
  if (!validateForm()) return;

  const plantData = {
    id: plantId.value ? Number(plantId.value) : Date.now(),
    name: plantName.value.trim(),
    category: plantCategory.value,
    price: Number(plantPrice.value),
    date: plantDate.value,
    description: plantDescription.value,
    img: plantImg.value || "https://images.unsplash.com/photo-1416879595882-3373a0480b5b?w=400&q=80"
  };

  if (plantId.value) {
    const index = plants.findIndex(p => p.id === Number(plantId.value));
    if (index !== -1) plants[index] = plantData;
  } else {
    plants.push(plantData);
  }

  saveToLocalStorage();
  formModal.style.display = "none";
  render();
});

// Sự kiện Tìm Kiếm
searchInput.addEventListener('input', (e) => {
  searchQuery = e.target.value;
  currentPage = 1;
  render();
});

// Sự kiện Sắp Xếp
sortSelect.addEventListener('change', (e) => {
  currentSort = e.target.value;
  render();
});

// Sự kiện bộ lọc Danh Mục (Pills)
filterPills.addEventListener('click', (e) => {
  if (e.target.classList.contains('pill')) {
    document.querySelectorAll('#filter-pills .pill').forEach(p => p.classList.remove('active'));
    e.target.classList.add('active');
    currentCategory = e.target.getAttribute('data-category');
    currentPage = 1;
    render();
  }
});

// Sự kiện thay đổi View Giao diện (Grid / Table)
viewTableBtn.addEventListener('click', () => {
  viewTableBtn.classList.add('active');
  viewGridBtn.classList.remove('active');
  currentView = 'table';
  render();
});

viewGridBtn.addEventListener('click', () => {
  viewGridBtn.classList.add('active');
  viewTableBtn.classList.remove('active');
  currentView = 'grid';
  render();
});

// Quản lý sự kiện Click XÓA và SỬA toàn cục
document.addEventListener("click", (e) => {
  // XÓA
  if (e.target.classList.contains("delete-btn")) {
    e.stopPropagation();
    const id = Number(e.target.dataset.id);
    if (confirm("Xóa cây này?")) {
      plants = plants.filter(p => p.id !== id);
      saveToLocalStorage();
      render();
    }
  }

  // SỬA
  if (e.target.classList.contains("edit-btn")) {
    e.stopPropagation();
    const id = Number(e.target.dataset.id);
    const plant = plants.find(p => p.id === id);
    if (!plant) return;

    formTitle.textContent = "Sửa cây";
    plantId.value = plant.id;
    plantName.value = plant.name;
    plantCategory.value = plant.category;
    plantPrice.value = plant.price;
    plantDate.value = plant.date;
    plantDescription.value = plant.description || "";
    plantImg.value = plant.img || "";

    formModal.style.display = "flex";
  }
});

// Đóng Modals
closeModalBtn.addEventListener('click', closeDetailModal);
detailModal.addEventListener('click', (e) => {
  if (e.target === detailModal) closeDetailModal();
});
closeFormModalBtn.addEventListener("click", closeFormModal);
cancelFormBtn.addEventListener("click", closeFormModal);

// Khởi chạy ứng dụng lần đầu khi tải trang
render();