function danhgia(){
    let tenmonan = document.getElementById("tenmon");
    let tenmonVal = tenmonan.innerText;
    let comment = document.getElementById("comment");
    let cmtValue = comment.innerText;
    var url = `http://localhost:8082/apidanhgia/danhgia?tenmon=`+tenmonVal+`&danhgia=`+cmtValue;
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