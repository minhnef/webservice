// Hàm hiển thị danh sách bàn
async function hienThiBan() {
    const response = await fetch('http://localhost:8082/apidatban/ban');
    const danhSachBan = await response.json();

    const tableBody = document.querySelector('#banTable tbody');
    tableBody.innerHTML = ''; // Xóa nội dung cũ

    danhSachBan.forEach(ban => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${ban.idban}</td>
            <td>${ban.vitri}</td>
            <td>${ban.trangthai}</td>
            <td><input type="checkbox" class="selectBan" data-id="${ban.idban}" ${ban.trangthai === 'đang sử dụng' ||ban.trangthai==='đã đặt' ? 'disabled' : ''}></td>
        `;
        tableBody.appendChild(row);
    });
}

function datBan() {
    // const selectedBans = Array.from(document.querySelectorAll('.selectBan:checked')).map(input => input.getAttribute('data-id'));
    const selectedBanIds = Array.from(document.querySelectorAll('.selectBan:checked'))
  .map(input => parseInt(input.getAttribute('data-id')));
   
    if (selectedBanIds.length > 0) {
        fetch(`http://localhost:8082/apidatban/datban`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(selectedBanIds)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Đặt bàn thất bại');
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            alert("Đặt bàn thành công.");
            // Cập nhật giao diện
        })
        .catch(error => {
            console.error('Error:', error);
            alert(error);
        });
    } else {
        alert('Vui lòng chọn ít nhất một bàn để đặt.');
    }
}


// Khởi tạo
document.addEventListener('DOMContentLoaded', () => {
    hienThiBan();
    document.getElementById('datBanBtn').addEventListener('click', datBan);
});
