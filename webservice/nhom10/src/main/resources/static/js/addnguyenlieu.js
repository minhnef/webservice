document.addEventListener('DOMContentLoaded', function () {
    const giaInput = document.getElementById('gia');
    const soluongInput = document.getElementById('soluong');
    const tongtienInput = document.getElementById('tongtien');
    function updateTongTien() {
        const gia = parseInt(giaInput.value) || 0;  // Giá trị mặc định là 0 nếu không nhập
        const soluong = parseInt(soluongInput.value) || 0;

        if (!giaInput.value || !soluongInput.value) {
            tongtienInput.value = ""; // Nếu giá hoặc số lượng rỗng, xóa giá trị tổng tiền
        } else {
            tongtienInput.value = (gia * soluong)// Tính tổng tiền
        }
    }

    giaInput.addEventListener('input', updateTongTien);
    soluongInput.addEventListener('input', updateTongTien);
});
