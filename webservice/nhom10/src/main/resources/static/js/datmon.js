const orderButton = document.querySelector('.order-item');

orderButton.addEventListener('click', () => {
  const product = {
    title: orderButton.dataset.title,
    price: orderButton.dataset.price,
    image: orderButton.dataset.image,
    quantity: 1 // Mặc định số lượng là 1
  };

  // Lấy danh sách sản phẩm hiện tại từ LocalStorage
  let cart = JSON.parse(localStorage.getItem('cart')) || [];

  // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
  const existingProduct = cart.find(item => item.title === product.title);

  if (existingProduct) {
    // Nếu sản phẩm đã tồn tại, tăng số lượng
    existingProduct.quantity++;
  } else {
    // Nếu sản phẩm chưa tồn tại, thêm vào giỏ hàng
    cart.push(product);
  }

  // Lưu danh sách sản phẩm vào LocalStorage
  localStorage.setItem('cart', JSON.stringify(cart));

  // Hiển thị thông báo (tùy chọn)
  alert('Đã thêm vào giỏ hàng!');
});