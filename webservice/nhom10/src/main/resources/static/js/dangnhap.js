// function dangnhap() {
//     // event.preventDefault(); // Ngăn chặn hành vi gửi form mặc định

//     let username = document.getElementById('username').value;
//     let password = document.getElementById('password').value;

//     const body = {
//         username: username,
//         password: password
//     };

//     fetch('http://localhost:8082/apitaikhoan/dangnhap', {
//         method: 'POST',
//         headers: {  
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify(body)
//     })
//     .then(response => {
//         if (!response.ok) {
//             throw new Error('Lỗi kết nối!');
//         }
//         return response.json();
//     })
//     .then(data => {
//         console.log(data); // In ra dữ liệu để kiểm tra
//         alert(JSON.stringify(data));
//     })
    
//     .catch(error => {
//         console.error(error);
//         alert('Có lỗi xảy ra: ' + error.message);
//     });
// }
function dangnhap() {
    const taikhoan = document.getElementById('username').value;
    const matkhau = document.getElementById('password').value;

    const data = {
        username: taikhoan,
        password: matkhau
    };

    fetch(`http://localhost:8082/apitaikhoan/dangnhap`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => {
        if (!response.ok) {
            return response.text().then(text => {
                throw new Error(text);
            });
        }
        return response.json();
    })
    .then(data => {
        if (data.redirectUrl) {
            window.location.href = data.redirectUrl;
        } else {
            alert(data.message);
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('Lỗi đăng nhập: ' + error.message);
    });
}


