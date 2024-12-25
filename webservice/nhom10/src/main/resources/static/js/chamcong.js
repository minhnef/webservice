function chamcong() {
    var idnhanvien = document.getElementById('idnv').value.trim();
    var url = `http://localhost:8082/apinhanvien/chamcong?id=${idnhanvien}`; // Sử dụng backtick
    fetch(url)
        .then(response => {
            if (response.ok) {
                return response.json(); // Thêm dấu ngoặc để gọi hàm
            } else {
                throw new Error('Lỗi kết nối mạng');
            }
        })
        .then(data => {
            alert('Xác nhận: ' + JSON.stringify(data));
        })
        .catch(error => {
            alert('Đã xảy ra lỗi: ' + error);
        });
}
