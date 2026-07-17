// ==========================================
// 1. DATA STORE (Fake API Response Data)
// ==========================================
const PET_STORE_DATA = {
    owners: [
        { id: 1, name: "Nguyễn Văn An", phone: "0901234567", email: "an@email.com", petsCount: 2, hasAccount: true },
        { id: 2, name: "Trần Thị Bình", phone: "0912345678", email: "binh@email.com", petsCount: 2, hasAccount: true },
        { id: 3, name: "Lê Minh Cường", phone: "0923456789", email: "cuong@email.com", petsCount: 1, hasAccount: false },
        { id: 4, name: "Phạm Thị Dung", phone: "0934567890", email: "dung@email.com", petsCount: 1, hasAccount: true },
        { id: 5, name: "Hoàng Văn Em", phone: "0945678901", email: "em@email.com", petsCount: 1, hasAccount: false }
    ],
    pets: [
        { id: 1, name: "Milo", species: "Dog", breed: "Golden Retriever", age: "3 tuổi", weight: "28.5 kg", owner: "Nguyễn Văn An", status: "Đang gửi", icon: "🐾" },
        { id: 2, name: "Kiki", species: "Cat", breed: "Anh lông ngắn", age: "2 tuổi", weight: "4.2 kg", owner: "Nguyễn Văn An", status: "Ở nhà", icon: "🐱" },
        { id: 3, name: "Buddy", species: "Dog", breed: "Poodle", age: "5 tuổi", weight: "6.8 kg", owner: "Trần Thị Bình", status: "Đang gửi", icon: "🐾" },
        { id: 4, name: "Tweety", species: "Bird", breed: "Vẹt Cockatiel", age: "1 tuổi", weight: "0.1 kg", owner: "Lê Minh Cường", status: "Ở nhà", icon: "🐦" },
        { id: 5, name: "Snow", species: "Rabbit", breed: "Holland Lop", age: "2 tuổi", weight: "1.8 kg", owner: "Phạm Thị Dung", status: "Đang gửi", icon: "🐰" }
    ],
    tickets: [
        { id: 1, petName: "Milo", petSpecies: "Dog", ownerName: "Nguyễn Văn An", checkIn: "20/05/2025", checkOut: "—", fee: "—", status: "Đang gửi" },
        { id: 2, petName: "Buddy", petSpecies: "Dog", ownerName: "Trần Thị Bình", checkIn: "18/05/2025", checkOut: "—", fee: "—", status: "Đang gửi" },
        { id: 3, petName: "Max", petSpecies: "Dog", ownerName: "Hoàng Văn Em", checkIn: "15/05/2025", checkOut: "22/05/2025", fee: "1.260.000đ", status: "Đã trả" },
        { id: 4, petName: "Kiki", petSpecies: "Cat", ownerName: "Nguyễn Văn An", checkIn: "10/05/2025", checkOut: "19/05/2025", fee: "1.060.000đ", status: "Đã trả" },
        { id: 5, petName: "Snow", petSpecies: "Rabbit", ownerName: "Phạm Thị Dung", checkIn: "21/05/2025", checkOut: "—", fee: "—", status: "Đang gửi" }
    ],
    distribution: [
        { species: "Dog", count: 3, percentage: 38, icon: "fa-dog" },
        { species: "Cat", count: 2, percentage: 25, icon: "fa-cat" },
        { species: "Bird", count: 1, percentage: 13, icon: "fa-crow" },
        { species: "Rabbit", count: 1, percentage: 13, icon: "fa-carrot" },
        { species: "Other", count: 1, percentage: 13, icon: "fa-paw" }
    ]
};
const kpiCard = document.querySelector(".kpi-grid")
let numberOfOwners = 0;
let numberOfPets = 0;
let numberOfRecord = 0;
let sumOfAvenue = 0;
let numberOfNotes = 0;
getStatAPI = "http://localhost:8084/admin/statistic"
function getStatistic(){
    fetch(getStatAPI)
        .then(response => {
            if(!response.ok) throw new Error("response invalid")
                return response.json();
        })
        .then(data=>{
            console.log("data: ",data.data.numberOfOwners);
            numberOfOwners=data.data.numberOfOwners
			console.log("numberOfOwners trong : ",numberOfOwners);
            numberOfPets=data.data.numberOfPets
            numberOfRecord=data.data.numberOfBoardingStatus
            sumOfAvenue=data.data.sumOfRevenue
            numberOfNotes=data.data.numberOfNotes
			genderStats(data.data); 
        })

    }
function genderStats(){
	
	console.log("numberOfOwners ngoài", numberOfOwners);
    kpiCard.innerHTML= `
        <div class="kpi-card">
            <div class="kpi-header">
                <div class="kpi-icon icon-orange"><i class="fa-solid fa-user"></i></div>
                <span class="badge badge-up">↑ +3</span>
            </div>
            <h2 id="kpi-owners">${numberOfOwners}</h2>
            <label>CHỦ NUÔI</label>
        </div>
        <div class="kpi-card">
            <div class="kpi-header">
                <div class="kpi-icon icon-purple"><i class="fa-solid fa-paw"></i></div>
                <span class="badge badge-up">↑ +5</span>
            </div>
            <h2 id="kpi-pets">${numberOfPets}</h2>
            <label>THÚ CƯNG</label>
        </div>
        <div class="kpi-card">
            <div class="kpi-header">
                <div class="kpi-icon icon-blue"><i class="fa-solid fa-clipboard-list"></i></div>
                <span class="badge badge-active">Active</span>
            </div>
            <h2 id="kpi-active">${numberOfRecord}</h2>
            <label>ĐANG GỬI</label>
        </div>
        <div class="kpi-card">
            <div class="kpi-header">
                <div class="kpi-icon icon-green"><i class="fa-solid fa-money-bill-wave"></i></div>
                <span class="badge badge-up">↑ +12%</span>
            </div>
            <h2 id="kpi-revenue">${sumOfAvenue}</h2>
            <label>DOANH THU</label>
        </div>
        <div class="kpi-card">
            <div class="kpi-header">
                <div class="kpi-icon icon-gray"><i class="fa-solid fa-pen-to-square"></i></div>
                <span class="badge badge-neutral">↑ +8</span>
            </div>
            <h2 id="kpi-notes">${numberOfNotes}</h2>
            <label>GHI CHÚ</label>
        </div>

    `
}
// ==========================================
// 2. CORE SPA APP CONTROL & NAVIGATION
// ==========================================


function initNavigation() {
    const navItems = document.querySelectorAll('.nav-item');
    const tabPanels = document.querySelectorAll('.tab-panel');

    navItems.forEach(item => {
        item.addEventListener('click', () => {
            // Thay đổi active class sidebar
            navItems.forEach(nav => nav.classList.remove('active'));
            item.classList.add('active');

            // Hiển thị tab panel tương ứng
            const targetTab = item.getAttribute('data-tab');
            tabPanels.forEach(panel => {
                if (panel.id === targetTab) {
                    panel.classList.add('active');
                } else {
                    panel.classList.remove('active');
                }
            });
        });
    });
}

// ==========================================
// 3. RENDER FUNCTION ENGINE
// ==========================================
function renderAllPanels() {
	getStatistic();
    genderStats();
    renderDashboardTickets();
    renderDistribution();
    renderOwnersTable();
    renderPetsTable();
    renderTicketsTable();
    renderMyPetsTable();
}

// Trạng thái Helper để tạo Class CSS
function getStatusClass(status) {
    if (status === 'Đang gửi') return 'status-sending';
    if (status === 'Đã trả') return 'status-returned';
    return 'status-home';
}

// Thú cưng avatar helper
function getPetIcon(species) {
    if (species === 'Dog') return '🐶';
    if (species === 'Cat') return '🐱';
    if (species === 'Bird') return '🐦';
    if (species === 'Rabbit') return '🐰';
    return '🐾';
}

// --- TAB 1: DASHBOARD RENDER ---
function renderDashboardTickets() {
    const tbody = document.getElementById('dashboard-tickets-tbody');
    tbody.innerHTML = PET_STORE_DATA.tickets.map(t => `
        <tr>
            <td>
                <div class="entity-info">
                    <div class="entity-avatar">${getPetIcon(t.petSpecies)}</div>
                    <div>
                        <div class="entity-name">${t.petName}</div>
                        <div class="entity-sub">${t.petSpecies}</div>
                    </div>
                </div>
            </td>
            <td class="cell-bold">${t.ownerName}</td>
            <td>${t.checkIn}</td>
            <td><span class="status-pill ${getStatusClass(t.status)}">${t.status}</span></td>
            <td class="cell-bold">${t.fee}</td>
            <td>
                <div class="action-icons-group">
                    <button class="action-btn" title="Xem chi tiết"><i class="fa-solid fa-eye"></i></button>
                </div>
            </td>
        </tr>
    `).join('');
}

function renderDistribution() {
    const container = document.getElementById('distribution-container');
    container.innerHTML = PET_STORE_DATA.distribution.map(d => `
        <div class="dist-row">
            <div class="dist-info">
                <span><i class="fa-solid ${d.icon}"></i> ${d.species}</span>
                <div class="dist-metrics"><b>${d.count}</b> ${d.percentage}%</div>
            </div>
            <div class="progress-bar-bg">
                <div class="progress-bar-fill" style="width: ${d.percentage}%"></div>
            </div>
        </div>
    `).join('');
}

// --- TAB 2: OWNERS RENDER ---
function renderOwnersTable() {
    const tbody = document.getElementById('owners-tbody');
    tbody.innerHTML = PET_STORE_DATA.owners.map(o => `
        <tr>
            <td>${o.id}</td>
            <td class="cell-bold">${o.name}</td>
            <td>${o.phone}</td>
            <td>${o.email}</td>
            <td><span class="cell-bold">${o.petsCount}</span> <i class="fa-solid fa-paw" style="color:#BFBFBF; font-size:12px; margin-left:4px;"></i></td>
            <td>
                <span class="acc-badge ${o.hasAccount ? 'acc-yes' : 'acc-no'}">
                    ${o.hasAccount ? '✓ Có TK' : 'Chưa có'}
                </span>
            </td>
            <td>
                <div class="action-icons-group">
                    <button class="action-btn" title="Xem"><i class="fa-solid fa-eye"></i></button>
                    <button class="action-btn" title="Sửa"><i class="fa-solid fa-pen"></i></button>
                    <button class="action-btn delete-btn" title="Xóa"><i class="fa-solid fa-trash-can"></i></button>
                </div>
            </td>
        </tr>
    `).join('');
    
    renderPagination('owners-pagination', 2, 1);
}

// --- TAB 3: PETS RENDER ---
function renderPetsTable() {
    const tbody = document.getElementById('pets-tbody');
    
    // Render Species filter tags ở trên đầu tab thú cưng
    const tagsContainer = document.getElementById('pets-species-tags');
    const speciesList = ['Tất cả', 'Dog', 'Cat', 'Bird', 'Rabbit', 'Other'];
    tagsContainer.innerHTML = speciesList.map((s, idx) => `
        <button class="filter-btn ${idx === 0 ? 'active' : ''}">${s}</button>
    `).join('');

    tbody.innerHTML = PET_STORE_DATA.pets.map(p => `
        <tr>
            <td>${p.id}</td>
            <td>
                <div class="entity-info">
                    <div class="entity-avatar">${p.icon}</div>
                    <div class="entity-name">${p.name}</div>
                </div>
            </td>
            <td><span class="filter-btn active" style="font-size:11px; padding:2px 10px;">${p.species}</span></td>
            <td>${p.breed}</td>
            <td>${p.age}</td>
            <td>${p.weight}</td>
            <td class="cell-bold">${p.owner}</td>
            <td><span class="status-pill ${getStatusClass(p.status)}">${p.status}</span></td>
            <td>
                <div class="action-icons-group">
                    <button class="action-btn" title="Sửa"><i class="fa-solid fa-pen"></i></button>
                    <button class="action-btn delete-btn" title="Xóa"><i class="fa-solid fa-trash-can"></i></button>
                </div>
            </td>
        </tr>
    `).join('');

    renderPagination('pets-pagination', 2, 1);
}

// --- TAB 4: TICKETS RENDER ---
function renderTicketsTable() {
    const tbody = document.getElementById('tickets-tbody');
    tbody.innerHTML = PET_STORE_DATA.tickets.map(t => `
        <tr>
            <td>${t.id}</td>
            <td>
                <div class="entity-info">
                    <div class="entity-avatar">${getPetIcon(t.petSpecies)}</div>
                    <div>
                        <div class="entity-name">${t.petName}</div>
                        <div class="entity-sub">${t.petSpecies}</div>
                    </div>
                </div>
            </td>
            <td class="cell-bold">${t.ownerName}</td>
            <td>${t.checkIn}</td>
            <td>${t.checkOut}</td>
            <td class="cell-bold">${t.fee}</td>
            <td><span class="status-pill ${getStatusClass(t.status)}">${t.status}</span></td>
            <td>
                <div class="action-icons-group">
                    <button class="action-btn" title="Xem chi tiết"><i class="fa-solid fa-eye"></i></button>
                    ${t.status === 'Đang gửi' ? `<button class="action-btn check-btn" title="Trả thú cưng"><i class="fa-solid fa-square-check"></i></button>` : ''}
                </div>
            </td>
        </tr>
    `).join('');

    renderPagination('tickets-pagination', 2, 1);
}

// --- TAB 5: MY PETS RENDER ---
function renderMyPetsTable() {
    const tbody = document.getElementById('mypets-tbody');
    // Giả lập dữ liệu của riêng tài khoản khách hàng này (VD: Nguyễn Văn An)
    const myPets = PET_STORE_DATA.pets.filter(p => p.owner === "Nguyễn Văn An");
    
    tbody.innerHTML = myPets.map((p, index) => `
        <tr>
            <td>${index + 1}</td>
            <td>
                <div class="entity-info">
                    <div class="entity-avatar">${p.icon}</div>
                    <div class="entity-name">${p.name}</div>
                </div>
            </td>
            <td><span class="filter-btn active" style="font-size:11px; padding:2px 10px;">${p.species}</span></td>
            <td>${p.breed}</td>
            <td>${p.age}</td>
            <td>${p.weight}</td>
            <td><span class="status-pill ${getStatusClass(p.status)}">${p.status}</span></td>
            <td>
                <div class="action-icons-group">
                    <button class="action-btn" title="Theo dõi nhật ký chăm sóc"><i class="fa-solid fa-eye"></i></button>
                </div>
            </td>
        </tr>
    `).join('');
}

// --- PAGINATION COMPONENT GENERATOR ---
function renderPagination(elementId, totalPages, currentPage) {
    const pagContainer = document.getElementById(elementId);
    if (!pagContainer) return;

    pagContainer.innerHTML = `
        <button class="page-node"><i class="fa-solid fa-arrow-left"></i></button>
        <button class="page-node ${currentPage === 1 ? 'active' : ''}">1</button>
        <button class="page-node ${currentPage === 2 ? 'active' : ''}">2</button>
        <span class="page-text">1/${totalPages}</span>
        <button class="page-node"><i class="fa-solid fa-arrow-right"></i></button>
    `;
}
getStatistic();
initNavigation();
renderAllPanels();