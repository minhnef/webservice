// revenue.js
export async function fetchRevenueAndOrderCount() {
    try {
        // Send GET request to API to fetch orders
        const response = await fetch('http://localhost:8083/api/dondathang/doanhthu', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            }
        });

        // Check if the response is valid
        if (!response.ok) {
            throw new Error('Unable to fetch revenue data');
        }

        // Parse the JSON response
        const orders = await response.json();

        // Calculate total revenue (sum of all order amounts)
        const totalRevenue = orders.reduce((sum, order) => sum + order.tonggia, 0);

        // Calculate total number of orders
        const totalOrders = orders.length;

        // Update total revenue and total orders on the interface
        document.getElementById('total-revenue').textContent = totalRevenue.toLocaleString('vi-VN') + ' VND';
        document.getElementById('total-orders').textContent = totalOrders;
    } catch (error) {
        console.error(error);
        document.getElementById('total-revenue').textContent = 'N/A';
        document.getElementById('total-orders').textContent = 'N/A';
    }
}

