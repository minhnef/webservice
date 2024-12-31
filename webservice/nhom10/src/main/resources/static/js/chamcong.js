function chamcong() {
    let idnhanvien = document.getElementById('idnv').value;
    let maxt = document.getElementById('maxacthuc').value;

    if(idnhanvien===''){
        alert("Vui lòng nhập ID nhân viên!")
        return
    }
    let url = `http://localhost:8082/apinhanvien/chamcong?id=${idnhanvien}&maxt=${maxt}`;

    fetch(url, {
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
        alert(data)
        // document.getElementById('content').innerText = data; // Hiển thị kết quả lên giao diện
    })
    .catch(error => {
        alert('Đã xảy ra lỗi: ' + error);
    });
}

