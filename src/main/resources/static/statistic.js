const statAPI = "http://localhost:8084/api/plants/get-stats";
let htmlStatistic = '';
let statisticDTO = {};
let totalPlantData = 0;
let categoryChart = null;

const categoryTableBody = document.querySelector('#categoryTableBody');
const totalPlant = document.querySelector("#total-plants");
const lastestPlantName = document.querySelector("#latest-plant-name");

function getStatisticData(){
	fetch(statAPI)
		.then(response => {
			if(!response.ok) throw new  Error(`HTTP error! Status: ${response.status}`);
			return response.json();
		})
		.then(data=>{
			statisticDTO = data.plantStatsDTO;
			if (statisticDTO) {
			                renderStatView();
			            }
		})
}

function renderStatView(){
	
	const total = statisticDTO.totalPlants || 1
	totalPlant.innerText = `${total}`
	Object.entries(statisticDTO.categoryStats).forEach(([categoryname, count]) => {
			const percentage = ((count / total) * 100).toFixed(0);
			htmlStatistic += `
								<tr>
								 	<td>${categoryname}</td>
									<td>${count}</td>
									<td>${percentage}%</td>
								</tr>
								`;
		});
		 categoryTableBody.innerHTML = htmlStatistic;			
		 lastestPlantName.innerText = 	statisticDTO.latestPlant.name;		
		 renderChart();
}

function renderChart() {

      const categoryCount = {};

  

      const ctx = document.getElementById("categoryChart");

      if(categoryChart){
          categoryChart.destroy();
      }
	  const categories = Object.keys(statisticDTO.categoryStats); // Ví dụ: ["Cây trồng trong nhà", "Cây ngoài trời"]
	  const counts = Object.values(statisticDTO.categoryStats);
      categoryChart = new Chart(ctx,{
          type:"doughnut",
          data:{
              labels:categories,
              datasets:[{
                  data:counts
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
getStatisticData();