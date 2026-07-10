
// Đường dẫn API từ local của bạn
const getAllAPI = 'http://localhost:8084/api/plants/';
const getCategoriesAPI = 'http://localhost:8084/category';
const createPlantAPI = 'http://localhost:8084/api/plants/';
const getAllCateAPI = 'http://localhost:8084/category';

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
  const addBtn = document.querySelector("#add-btn");
  const closeFormModalBtn = document.getElementById("close-form-modal");
  const cancelFormBtn = document.getElementById("cancel-form");
  const btnLogout = document.getElementById('btn-logout');
  let plants = []
  let oldPlantName = "";
  let backendCurrentPage = 1;
  let backendTotalPages = 1;
  let backendTotalItems = 0;
  
  let currentView = 'grid'; // 'grid' hoặc 'table'
  let currentCategory = 'all';
  let searchQuery = '';
  let currentSort = 'name-asc';
  let currentPage = 1;
  const itemsPerPage = 5;
  let inputSearch ="";
  let orderField = "";
  let orderBy = "";
  
  let categoryList = [];

  let categoryChart = null;
  
function createPlant(plantRequest) {
    fetch(createPlantAPI, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(plantRequest)
    })
        .then(response => {
            if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
            return response.json();
        })
        .then(data => {
            loadPlantsFromServer(currentPage, itemsPerPage);
        })
}
function loadAllCategory() {
	plantCategory.innerHTML = '';
    fetch(getCategoriesAPI)
        .then(response => {
            if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
            return response.json();
        })
        .then(data => {
            const categories = data.categoryDTO || [];
			categoryList = categories;
            console.log("Danh sách Category thực tế:", categories);
            if (plantCategory) {
                // Render danh sách các thẻ <option> dựa theo cấu trúc { name: "..." }
                plantCategory.innerHTML += categories.map(cat => `
			          <option value="${cat.name}">${cat.name}</option>
			        `).join('');
            }
			//render();
        })
        .catch(error => console.error('Lỗi lấy danh sách Category:', error));
}
function loadPlantsFromServer(pageRequest = 1, limit = 2) {
    const urlWithPaging = `${getAllAPI}?page=${currentPage}&size=${limit}`;
    fetch(urlWithPaging)
        .then(response => {
            // Kiểm tra nếu phản hồi từ server không thành công (ví dụ: lỗi 404, 500)
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json(); // Chuyển đổi dữ liệu nhận được thành JSON
        })
        .then(data => {
            // Truy cập vào mảng danh sách nằm trong thuộc tính 'plantDTO'
            plants = data.plantDTO || [];

            backendTotalItems = data.totalItems || 0;
            backendTotalPages = data.totalPages || 0;
            //currentPage = data.page || pageRequest;
            console.log("Trang hiện tại vừa cập nhật thành công:", currentPage);
            render();
        })
        .catch(error => {
            // Xử lý lỗi nếu có (lỗi kết nối, lỗi parse JSON,...)
            console.error('Có lỗi xảy ra khi gọi API:', error);
        });
}

function deletePlant(name) {
    const deletePlantAPI = `http://localhost:8084/api/plants/delete/${encodeURIComponent(name)}`
    fetch(deletePlantAPI, {
        method: 'DELETE',
        header: {
            'Content-Type': 'application/json'
        }

    })
        .then(response => {
            if (!response.ok) throw new Error(`HTTP error! Status: ${response.status}`)
        })
        .then(data => {
            loadPlantsFromServer(currentPage, itemsPerPage);
        })
}
function updatePlantToServer(oldName, updatedPlantData) {
    const updatePlantAPI = `http://localhost:8084/api/plants/update/${encodeURIComponent(oldName)}`
    fetch(updatePlantAPI,
        {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(updatedPlantData)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            loadPlantsFromServer(currentPage, itemsPerPage)
        })
}
	
function filterSortSearch(keyword, category, orderBy, fieldName, page = 1, limit = 5){
	const url = `${getAllAPI}search?keyword=${keyword}&category=${category}&by=${orderBy}&order=${fieldName}&page=${page}&size=${limit}`;
	
	fetch(url)
		.then(response =>{
			if(!response.ok) throw new Error(`HTTP error! Status: ${response.status}`);
			return response.json();
		})
		.then(data => {
		      plants = data.plantDTO || [];	       // Hứng mảng cây tìm được
		      backendTotalItems = data.totalItems || 0;
		      backendTotalPages = data.totalPages || 1;
		      currentPage = data.page || page;        // Cập nhật trang hiện tại
		      
		      console.log("Dữ liệu tìm kiếm/phân trang mới:", data);
		      render(); // Vẽ lại giao diện sau khi đã có dữ liệu mới
		 })
		 .catch(error => {
		     console.error('Có lỗi xảy ra khi gọi API Search:', error);
		 });
		
}

  // --- CÁC HÀM BỔ TRỢ ---


  function renderChart() {

      const categoryCount = {};

      plants.forEach(plant => {
          categoryCount[plant.category] =
              (categoryCount[plant.category] || 0) + 1;
      });

      const labels = Object.keys(categoryCount);
      const data = Object.values(categoryCount);

      const ctx = document.getElementById("categoryChart");

      if(categoryChart){
          categoryChart.destroy();
      }

      categoryChart = new Chart(ctx,{
          type:"doughnut",
          data:{
              labels:labels,
              datasets:[{
                  data:data
              }]
          },
          options:{
              responsive:true,
              plugins:{
                  legend:{
                      position:"bottom"
                  }
              }
          }
      });

  }
  function openDetailModal(plant) {
    modalImage.src = plant.img || "";
    modalImage.alt = plant.name;
    modalName.textContent = plant.name;
    modalCategory.textContent = plant.category;
    modalPrice.textContent = plant.price.toLocaleString() + " VNĐ";
    modalDate.textContent = formatDate(plant.plantDate);
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



  // --- HÀM RENDER CHÍNH ---
  function render() {

    // Thanh category
	categoryRender=`<span class="pill active" data-category="all">Tất cả</span>`;
	for( let cate of categoryList){
		categoryRender += `
			<span class="pill" data-category="${cate.name}">${cate.name}</span>
		`
	}
	filterPills.innerHTML = categoryRender;

    // HIỂN THỊ VIEW GIAO DIỆN
    if (currentView === 'table') {
      tableWrap.style.display = 'block';
      gridContainer.style.display = 'none';

      tableBody.innerHTML = plants.map((plant, index) => `
        <tr>
          <td>${(currentPage - 1) * itemsPerPage + index + 1}</td>
          <td><span class="plant-name" data-id="${plant.id}">${plant.name}</span></td>
          <td><span class="badge ${getBadgeClass(plant.category)}">${plant.category}</span></td>
          <td>${plant.price.toLocaleString()}</td>
          <td>${formatDate(plant.plantDate)}</td>
          <td class="actions">
            <button class="btn btn-sm btn-outline edit-btn" data-id="${plant.id}">✏️ Sửa</button>
            <button class="btn btn-sm btn-danger delete-btn" data-id="${plant.id}">🗑️ Xóa</button>
          </td>
        </tr>
      `).join('');
    } else {
      tableWrap.style.display = 'none';
      gridContainer.style.display = 'grid';

      gridContainer.innerHTML = plants.map(plant => `
        <div class="plant-card" data-id="${plant.id}">
          <img class="card-img" src="${plant.img}" alt="${plant.name}" />
          <div class="card-body">
            <div class="card-name">${plant.name}</div>
            <span class="badge ${getBadgeClass(plant.category)}">${plant.category}</span>
            <div class="card-price">${plant.price.toLocaleString()} VNĐ</div>
            <div class="card-date">🗓 ${formatDate(plant.plantDate)}</div>
            <div class="actions" style="margin-top:.75rem;">
              <button class="btn btn-sm btn-outline edit-btn" data-id="${plant.id}">✏️ Sửa</button>
              <button class="btn btn-sm btn-danger delete-btn" data-id="${plant.id}">🗑️ Xóa</button>
            </div>
          </div>
        </div>
      `).join('');
    }

    // RENDER THANH PHÂN TRANG
	  const range = [];
	  const delta = 2;
	  let last ;
	  const rangeWithDot= [];
	  for(let i = 1 ; i<= backendTotalPages; i++){
		if(i === 1 || i === backendTotalPages || (currentPage-delta <= i && i <= currentPage+delta))
		{
			range.push(i);
		}  
	  }
	  
	  for(let i of range){
		if(last){
			if(i-last === 2){
				rangeWithDot.push(last+1)
			}else if(i-last > 2){
				rangeWithDot.push("...")
			}
		}
		rangeWithDot.push(i);
		last = i;
	  }
	  
	  
      let paginationHTML = "";
	  
	  paginationHTML += 
	  	  `<button class="page-btn" ${currentPage === 1 ? "disabled" : ""} data-page= "${currentPage-1}">  ← Prev </button>`;
		  
      rangeWithDot.forEach(page => {
		if(page === '...'){
			paginationHTML += `<span class="page-dots">${page}</span>`;
		}else {
			paginationHTML += `<button class="page-btn" ${currentPage == page ? "active" : ""} data-page= "${page}">${page}</button>`
		}
		
	  })
	  
	  paginationHTML += 
	  `<button class="page-btn" ${currentPage === backendTotalPages ? "disabled" : ""} data-page= "${currentPage+1}"> Next → </button>`;
	  console.log(currentPage);
      paginationContainer.innerHTML = paginationHTML;
	  renderChart();
  }
  
  paginationContainer.addEventListener("click", (e) => {
      const btn = e.target.closest(".page-btn");
      if(!btn) return;
      const page = Number(btn.dataset.page);
	  currentPage = page;
      loadPlantsFromServer(page, itemsPerPage);

  });
  
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

    addBtn.addEventListener("click", () => {
	console.log("click thêm");
	 // loadAllCategory();
      formTitle.textContent = "Thêm cây";
      plantForm.reset();
      plantId.value = "";
      formModal.style.display = "flex";
    });


  // Quản lý sự kiện Click XÓA và SỬA toàn cục
   document.addEventListener("click", (e) => {
     // XÓA
     if (e.target.classList.contains("delete-btn")) {
       e.stopPropagation();
       const id = Number(e.target.dataset.id);
       if (confirm("Xóa cây này?")) {
         plant = plants.filter(p => p.id === id);
		 console.log(plant[0].name);
		 deletePlant(plant[0].name);
        // saveToLocalStorage();
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
       plantDate.value = plant.plantDate;
       plantDescription.value = plant.description || "";
       plantImg.value = plant.img || "";
       oldPlantName = plant.name;
       formModal.style.display = "flex";
     }
   });
   
  // Sự kiện Submit Form (Thêm / Sửa)
  plantForm.addEventListener("submit", (e) => {
    e.preventDefault();
    if (!validateForm()) return;

    const plantData = {
     // id: plantId.value ? Number(plantId.value) : null,
      name: plantName.value.trim(),
      category: plantCategory.value,
      price: Number(plantPrice.value),
      date: plantDate.value,
      description: plantDescription.value,
      img: plantImg.value || "https://images.unsplash.com/photo-1416879595882-3373a0480b5b?w=400&q=80"
    };

    if (plantId.value) {
      const index = plants.findIndex(p => p.id === Number(plantId.value));
      
	  updatePlantToServer(oldPlantName,plantData)
    } else {
		console.log("plantData: ", plantData);
		createPlant(plantData);
      
    }

   
    formModal.style.display = "none";
    
  });

  // Sự kiện Tìm Kiếm
  searchInput.addEventListener('input', (e) => {
    inputSearch = e.target.value.trim();
    currentPage = 1;
    filterSortSearch(inputSearch, "", "", "", currentPage, itemsPerPage);
  });

  //thừa thải
 // searchInput.addEventListener('chane',(e)=>{
//	filterSortSearch(inputSearch,"","","");
//  })
  // Sự kiện Sắp Xếp
  sortSelect.addEventListener('change', (e) => {
	
    currentSort = e.target.value;
	[field, order] = currentSort.split("-");
	orderBy= field
	orderField=order
	filterSortSearch(
	      inputSearch,
	      currentCategory === "all" ? "" : currentCategory,
	      orderBy,
	      orderField,
	      currentPage,
	      itemsPerPage
	  );
  });

  // Sự kiện bộ lọc Danh Mục (Pills)
  filterPills.addEventListener('click', (e) => {
	const pill = e.target.closest(".pill");
	if(!pill) return;
	document.querySelectorAll('#filter-pills .pill')
	        .forEach(p=> p.classList.remove("active"));
	pill.classList.add("active");
	
	currentCategory = pill.dataset.category;
	currentPage = 1;
	console.log("currentCategory",currentCategory);
	if(currentCategory === "all"){
		loadPlantsFromServer(currentPage,itemsPerPage);
	}else{
		filterSortSearch(
		            inputSearch,
		            currentCategory,
		            orderBy,
		            orderField,
		            currentPage,
		            itemsPerPage
		        );
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

 

  // Đóng Modals
  closeModalBtn.addEventListener('click', closeDetailModal);
  detailModal.addEventListener('click', (e) => {
    if (e.target === detailModal) closeDetailModal();
  });
  closeFormModalBtn.addEventListener("click", closeFormModal);
  cancelFormBtn.addEventListener("click", closeFormModal);

  function checkAuthDOM() {
      const isLoggedIn = localStorage.getItem("isLoggedIn") === "true";
      const guestElements = document.querySelectorAll('.auth-guest');
      const userElements = document.querySelectorAll('.auth-user');

      if (isLoggedIn) {
          // Đã đăng nhập: Ẩn Đăng ký/Đăng nhập, Hiện Đăng xuất
          guestElements.forEach(el => el.style.display = 'none');
          userElements.forEach(el => el.style.display = 'inline-block');
      } else {
          // Chưa đăng nhập: Hiện Đăng ký/Đăng nhập, Ẩn Đăng xuất
          guestElements.forEach(el => el.style.display = 'inline-block');
          userElements.forEach(el => el.style.display = 'none');
      }
  }

  // Lắng nghe sự kiện bấm nút Đăng xuất
  if (btnLogout) {
      btnLogout.addEventListener('click', function(e) {
          e.preventDefault();
          
          if (confirm("Bạn có chắc chắn muốn đăng xuất không?")) {
              fetch('http://localhost:8084/logout', {
                  method: 'POST'
              })
              .then(() => {
                  // Đăng xuất thành công -> Xóa cờ và đẩy về trang login
                  localStorage.removeItem("isLoggedIn");
                  window.location.href = './login.html?logout';
              })
              .catch(error => {
                  console.error('Lỗi khi đăng xuất:', error);
                  alert('Không thể kết nối đến server để đăng xuất.');
              });
          }
      });
  }

  // Khởi chạy quét giao diện ngay khi tải trang chủ index.html
  checkAuthDOM();
  
  loadAllCategory()
loadPlantsFromServer(currentPage, itemsPerPage);
