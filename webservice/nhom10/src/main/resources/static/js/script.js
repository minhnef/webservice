const modal = document.getElementById("contact-modal");
const openModalBtn = document.getElementById("open-contact-modal");
const closeModalBtn = modal.querySelector(".close-button");

openModalBtn.addEventListener("click", (e) => {
    e.preventDefault();
    modal.style.display = "block";
});

closeModalBtn.addEventListener("click", () => {
    modal.style.display = "none";
});

window.addEventListener("click", (e) => {
    if (e.target === modal) {
        modal.style.display = "none";
    }
});
document.addEventListener("DOMContentLoaded", () => {
    const orderButtons = document.querySelectorAll(".order-item");
    const modal = document.querySelector("#order-modal");
    const modalImage = modal.querySelector(".modal-image");
    const modalTitle = modal.querySelector(".product-title");
    const modalPrice = modal.querySelector(".current-price");
    const totalPrice = modal.querySelector("#total-price");
    const quantityInput = modal.querySelector("#quantity");
    const plusButton = modal.querySelector(".plus");
    const minusButton = modal.querySelector(".minus");

    let pricePerItem = 0;

    orderButtons.forEach((button) => {
        button.addEventListener("click", () => {
            const title = button.getAttribute("data-title");
            const price = button.getAttribute("data-price");
            const image = button.getAttribute("data-image");

            modalImage.src = image;
            modalImage.alt = title;
            modalTitle.textContent = title;
            modalPrice.textContent = price;
            pricePerItem = parseInt(price.replace(/[^0-9]/g, "")); 
            modalPrice.setAttribute("data-price", pricePerItem);
            quantityInput.value = 1; 
            totalPrice.textContent = price;

            modal.style.display = "block";
        });
    });

    const closeButton = modal.querySelector(".close-button");
    closeButton.addEventListener("click", () => {
        modal.style.display = "none";
    });


    plusButton.onclick = () => {
        let currentQuantity = +(quantityInput.value) + 1 || 1;
        console.log(currentQuantity);

        // currentQuantity += 1;

        // quantityInput.value = currentQuantity;

        const total = pricePerItem * currentQuantity;
        totalPrice.textContent = total.toLocaleString() + " ₫";
    };

    minusButton.onclick = () => {
        let currentQuantity = parseInt(quantityInput.value) - 1 || 1;
        if (currentQuantity > 1) {
            // currentQuantity -= 1;
            // quantityInput.value = currentQuantity;

            const total = pricePerItem * currentQuantity;
            totalPrice.textContent = total.toLocaleString() + " ₫";
        }
    };

    quantityInput.addEventListener("input", () => {
        let currentQuantity = parseInt(quantityInput.value) || 1;
        if (currentQuantity < 1) currentQuantity = 1;
        quantityInput.value = currentQuantity;

        const total = pricePerItem * currentQuantity;
        totalPrice.textContent = total.toLocaleString() + " ₫";
    });
});

document.addEventListener('DOMContentLoaded', () => {
    const minusButton = document.querySelector('.minus');
    const plusButton = document.querySelector('.plus');
    const quantityInput = document.querySelector('#quantity');


    minusButton.addEventListener('click', () => {
        let currentValue = parseInt(quantityInput.value) || 1;
        if (currentValue > 1) {
            quantityInput.value = currentValue - 1;
        }
    });

    plusButton.addEventListener('click', () => {
        let currentValue = parseInt(quantityInput.value) || 1;
        quantityInput.value = currentValue + 1;
    });
});
document.getElementById("search-button").addEventListener("click", function () {
    const searchValue = document.getElementById("search-bar").value.toLowerCase();
    const categoryValue = document.getElementById("filter-category").value;
    const priceValue = document.getElementById("filter-price").value;

    const products = document.querySelectorAll(".col-product");

    products.forEach((product) => {
        const productTitle = product.querySelector(".card-title-link").textContent.toLowerCase();
        const productCategory = product.getAttribute("data-category");
        const productPrice = product.getAttribute("data-price");

        let matchesSearch = searchValue === "" || productTitle.includes(searchValue);
        let matchesCategory = categoryValue === "" || productCategory === categoryValue;
        let matchesPrice = false;

        if (priceValue === "" || productPrice === priceValue) {
            matchesPrice = true;
        } else if (priceValue === "duoi-50" && productPrice === "duoi-50") {
            matchesPrice = true;
        } else if (priceValue === "50-100" && productPrice === "50-100") {
            matchesPrice = true;
        } else if (priceValue === "tren-100" && productPrice === "tren-100") {
            matchesPrice = true;
        }

        if (matchesSearch && matchesCategory && matchesPrice) {
            product.style.display = "block";
        } else {
            product.style.display = "none";
        }
    });
});
if (matchesSearch && matchesCategory && matchesPrice) {
    product.classList.add("show");
} else {
    product.classList.remove("show");
}




