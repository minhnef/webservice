function danhgia() {
    let tenmonan = document.getElementById("tenmon").value;
    let comment = document.getElementById("comment").value;

    // Kiểm tra nếu tên món ăn hoặc nhận xét bị bỏ trống
    if (tenmonan === '') {
        alert("Vui lòng nhập tên món ăn cần đánh giá");
        return;
    }
    if (comment === '') {
        alert('Vui lòng để lại đánh giá của bạn cho món: ' + tenmonan);
        return;
    }

    // Mã hóa các giá trị nhập liệu để đảm bảo chúng được truyền đúng cách trong URL
    let url = `http://localhost:8082/apichitiet/danhgia?mahoatenmon=${tenmonan}&mahoadanhgia=${comment}`;

    // Gửi yêu cầu GET đến máy chủ
    fetch(url,{
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (response.ok) {
            return response.text(); // Chuyển đổi phản hồi thành text
        } else {
            throw new Error('Lỗi kết nối mạng');
        }
    })
    .then(data => {
        alert('Đánh giá đã được gửi: ' + data);
    })
    .catch(error => {
        alert('Đã xảy ra lỗi: ' + error);
    });
}
