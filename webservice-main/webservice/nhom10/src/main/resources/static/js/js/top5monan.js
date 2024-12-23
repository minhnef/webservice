
async function fetchTopDishes() {
    try {
        // Gửi yêu cầu GET đến API để lấy dữ liệu món ăn
        const response = await fetch('http://localhost:8083/api/monan/top5', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        });

        // Kiểm tra nếu phản hồi không hợp lệ
        if (!response.ok) {
            throw new Error('Không thể lấy dữ liệu món ăn');
        }

        // Parse dữ liệu JSON trả về
        const dishes = await response.json();

        // Lọc 5 món ăn bán chạy nhất
        const topDishes = dishes.slice(0, 5);

        // Lấy tên món ăn và số lượng bán
        const dishNames = topDishes.map(dish => dish.tenmon);
        const dishCounts = topDishes.map(dish => dish.monanCount);

        // Tổng số món ăn bán được
        const totalSales = dishCounts.reduce((acc, count) => acc + count, 0);

        // Các màu sắc cho biểu đồ
        const colors = [
            'rgba(255, 99, 132, 0.6)',  // Màu đỏ
            'rgba(54, 162, 235, 0.6)',   // Màu xanh dương
            'rgba(255, 206, 86, 0.6)',   // Màu vàng
            'rgba(75, 192, 192, 0.6)',   // Màu xanh lá cây
            'rgba(153, 102, 255, 0.6)'   // Màu tím
        ];

        // Vẽ biểu đồ với Chart.js
        const ctx = document.getElementById('topDishesChart').getContext('2d');
        new Chart(ctx, {
            type: 'pie', // Biểu đồ tròn
            data: {
                labels: dishNames,  // Tên các món ăn
                datasets: [{
                    label: 'Số lượng bán',
                    data: dishCounts,  // Số lượng bán của từng món
                    backgroundColor: colors, // Màu sắc cho mỗi miếng bánh
                    borderColor: colors.map(color => color.replace('0.6', '1')), // Biên cho miếng bánh (màu đậm hơn)
                    borderWidth: 2
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: {
                        position: 'top',
                        labels: {
                            font: {
                                size: 14,
                                weight: 'bold'
                            }
                        }
                    },
                    datalabels: {
                        formatter: (value, context) => {
                            // Tính phần trăm
                            let total = context.dataset.data.reduce((acc, val) => acc + val, 0);
                            let percentage = ((value / total) * 100).toFixed(2) + '%';  // Tính phần trăm
                            return percentage;  // Trả về phần trăm
                        },
                        color: 'white', // Màu chữ của phần trăm
                        font: {
                            weight: 'bold',
                            size: 16
                        }
                    },
                    tooltip: {
                        callbacks: {
                            label: function(tooltipItem) {
                                return tooltipItem.label + ': ' + tooltipItem.raw + ' món';
                            }
                        }
                    }
                }
            }
        });
    } catch (error) {
        console.error(error);
    }
}

// Gọi hàm khi trang web tải
window.onload = fetchTopDishes;
