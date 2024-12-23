// login.js

async function login() {
    const username = 'admin';
    const password = 'admin123';

    const response = await fetch('http://localhost:8083/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, password }), // Gửi dữ liệu đăng nhập
        credentials: 'same-origin' // Gửi cookies nếu có session
    });

    if (response.ok) {
        const data = await response.json();
        localStorage.setItem('authToken', data.token);  // Lưu token vào localStorage
        return true;
    } else {
        throw new Error('Đăng nhập không thành công');
    }
}
