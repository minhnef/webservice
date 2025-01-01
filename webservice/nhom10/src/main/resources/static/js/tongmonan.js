// dish.js
export async function fetchDishCount() {
    try {
        // Send GET request to API to fetch the list of dishes
        const response = await fetch('http://localhost:8082/apithucdon', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',  // Ensure header is valid
            }
        });

        // Check if the response is invalid
        if (!response.ok) {
            throw new Error('Unable to fetch dish data');
        }

        // Parse the JSON response
        const dishes = await response.json();

        // Get the number of dishes
        const dishCount = dishes.length;

        // Update the dish count on the interface
        document.getElementById('dish-count').textContent = dishCount;
    } catch (error) {
        console.error(error);
        document.getElementById('dish-count').textContent = 'N/A'; // Display 'N/A' if an error occurs
    }
}
