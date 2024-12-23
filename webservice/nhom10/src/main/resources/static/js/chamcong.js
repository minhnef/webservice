function chamCong() {
    // Lấy ID nhân viên từ trường input
    var employeeId = document.getElementById("employeeId").value;
    var resultDiv = document.getElementById("result");

    // Kiểm tra nếu ID không được nhập
    if (!employeeId) {
        resultDiv.textContent = "Vui lòng nhập ID nhân viên.";
        return;
    }

    // Gửi yêu cầu GET đến API Spring Boot
    fetch(`http://localhost:8082/apinhanvien/chamcong?id=${employeeId}`)
        .then(response => {
            if (response.ok) {
                return response.json();  // Chuyển phản hồi thành JSON
            } else {
                throw new Error('Không thể điểm danh nhân viên');
            }
        })
        .then(data => {
            // Hiển thị kết quả trả về từ API
            resultDiv.innerHTML = `
                <p><strong>Kết quả:</strong> ${data}</p>
            `;
        })
        .catch(error => {
            // Hiển thị thông báo lỗi nếu có
            resultDiv.textContent = "Đã xảy ra lỗi khi điểm danh: " + error.message;
        });
}