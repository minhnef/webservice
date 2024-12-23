<?php
if ($_SERVER["REQUEST_METHOD"] === "POST") {
    $role = $_POST['role'];
    $username = $_POST['username'];
    $password = $_POST['password'];
    if ($username === "admin" && $password === "123") {
        if ($role === "employee") {
            echo "Đăng nhập thành công với vai trò Nhân viên!";
        } elseif ($role === "manager") {
            echo "Đăng nhập thành công với vai trò Quản lý!";
        }
    } else {
        echo "Tên đăng nhập hoặc mật khẩu sai!";
    }
}
?>
