// employee.js
export async function fetchEmployeeCount() {
    try {
        // Fetch data from the API
        const response = await fetch('http://localhost:8082/nhanvien/all');
        if (!response.ok) throw new Error('Failed to fetch data');

        // Parse the JSON response
        const employees = await response.json();

        // Get the total number of employees (length of the array)
        const employeeCount = employees.length;

        // Update the HTML with the number of employees
        document.getElementById('employee-count').textContent = employeeCount;
    } catch (error) {
        console.error(error);
        document.getElementById('employee-count').textContent = 'N/A'; // In case of error
    }
}
