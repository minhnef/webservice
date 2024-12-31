// Tệp dangnhap.js
function dangnhap(event) {
    event.preventDefault(); // Ngăn chặn hành vi gửi form mặc định

    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;

    const data = {
        username: username,
        password: password
    };

    fetch('http://localhost:8082/apitaikhoan/dangnhap', {
        method: 'POST',
        headers: {  
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Lỗi kết nối!');
        }
        return response.json();
    })
    .then(message => {
        console.log(message);
        alert(JSON.stringify(message))  ;
    })
    .catch(error => {
        console.error(error);
        alert('Có lỗi xảy ra: ' + error.message);
    });
}
