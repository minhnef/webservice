function thanhtoan(){
    let iddh = document.getElementById('id').value
    let tientra = document.getElementById('tientra').value

    if(iddh === '' || tientra ===''){
        alert('Vui lòng nhập đầy đủ thông tin')
        return
    }
    const data = {
        id : parseInt(iddh),
        tientra: parseInt(tientra)
    };
    
    let url = `http://localhost:8082/apidonhang/thanhtoandonhang`

    fetch(url, {
        method:'PUT',
        headers:{
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response=>{
        if(response.ok){
            return response.text();
        }else{
            throw new Error('Lỗi kết nối');
        }
    })
    .then(data=>{
        alert(data);
    })
    .catch(error =>{
        alert('Lỗi: '+error);
    })
}

function apvoucher(){
    let iddh = document.getElementById('id').value
    let voucher = document.getElementById('voucher').value

    if(iddh === '' || voucher ===''){
        alert('Vui lòng nhập đầy đủ thông tin')
        return
    }
    const data = {
        id : parseInt(iddh),
        voucher: voucher
    };
    alert(iddh)
    alert(voucher)
    let url = `http://localhost:8082/apidonhang/apmavoucher`

    fetch(url, {
        method:'PUT',
        headers:{
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response=>{
        if(response.ok){
            return response.text();
        }else{
            throw new Error('Lỗi kết nối');
        }
    })
    .then(data=>{
        alert(data);
    })
    .catch(error =>{
        alert('Lỗi: '+error);
    })
}