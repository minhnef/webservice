
async function kiemtra() {
    closeModal();
    const id = document.getElementById("id").value;
    const apiUrl = `http://localhost:8082/apidonhang/xemdon?id=${id}`;

    try {
        const response = await fetch(apiUrl);

        if (!response.ok) {
            throw new Error('Không thể lấy thông tin đơn hàng');
        }

        const orderData = await response.json();

        // Hiển thị thông tin đơn hàng
        let orderInfo = `
                ID Đơn Hàng: ${orderData.iddonhang}
                Địa Chỉ Giao Hàng: ${orderData.diachigiaohang || 'Chưa cập nhật'}
                Tổng Giá: ${orderData.tonggia} VNĐ
            `;

        // Hiển thị chi tiết đơn hàng
        orderInfo += "\n\nChi tiết Đơn Hàng:\n";
        if (orderData && orderData.chitietdonhangs && orderData.chitietdonhangs.length > 0) {
            for (let i = 0; i < orderData.chitietdonhangs.length; i++) {
                const item = orderData.chitietdonhangs[i];
                orderInfo += `
                        ID Chi Tiết: ${item.idchitiet}
                        Yêu Cầu: ${item.yeucaukh || 'Chưa cập nhật'}
                        Ngày Đặt: ${item.ngaydat || 'Chưa cập nhật'}
                        Trạng Thái: ${item.trangthai || 'Chưa cập nhật'}
                    `;

                // Hiển thị danh sách bàn
                orderInfo += "\n\nDanh Sách Bàn:\n";
                if (item.bans && item.bans.length > 0) {
                    for (let j = 0; j < item.bans.length; j++) {
                        const ban = item.bans[j];
                        orderInfo += `
                                ID Bàn: ${ban.idban}
                                Vị trí: ${ban.vitri || 'Chưa cập nhật'}
                                Trạng Thái: ${ban.trangthai || 'Chưa cập nhật'}
                            `;
                    }
                } else {
                    orderInfo += "\nKhông có bàn nào.";
                }
            }
        } else {
            orderInfo += "\nKhông có chi tiết đơn hàng.";
        }

        document.getElementById("orderInfo").innerText = orderInfo;
        document.getElementById("modal").style.display = "block"; // Hiện modal
    } catch (error) {
        alert(error.message);
    }
}


function closeModal() {
    document.getElementById("modal").style.display = "none"; // Ẩn modal
}


function thanhtoan() {
    let iddh = document.getElementById('id').value
    let tientra = document.getElementById('tientra').value

    if (iddh === '' || tientra === '') {
        alert('Vui lòng nhập đầy đủ thông tin')
        return
    }
    const data = {
        id: parseInt(iddh),
        tientra: parseInt(tientra)
    };

    let url = `http://localhost:8082/apidonhang/thanhtoandonhang`

    fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error('Lỗi kết nối');
            }
        })
        .then(data => {
            alert(data);
        })
        .catch(error => {
            alert('Lỗi: ' + error);
        })
}

function apvoucher() {
    let iddh = document.getElementById('id').value
    let voucher = document.getElementById('voucher').value

    if (iddh === '' || voucher === '') {
        alert('Vui lòng nhập đầy đủ thông tin')
        return
    }
    const data = {
        id: parseInt(iddh),
        voucher: voucher
    };
    
    let url = `http://localhost:8082/apidonhang/apmavoucher`

    fetch(url, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            if (response.ok) {
                return response.text();
            } else {
                throw new Error('Lỗi kết nối');
            }
        })
        .then(data => {
            alert(data);
        })
        .catch(error => {
            alert('Lỗi: ' + error);
        })
}