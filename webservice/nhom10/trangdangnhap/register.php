<?php
$servername = "localhost"; // Tên máy chủ
$username = "root";        // Tên người dùng CSDL
$password = "";            // Mật khẩu CSDL
$dbname = "amthucviet";     // Tên database

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Kết nối thất bại: " . $conn->connect_error);
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $username = $_POST['username'];
    $password = $_POST['password'];
    $confirm_password = $_POST['confirm_password'];
    $role = $_POST['role'];

    if ($password != $confirm_password) {
        echo "<script>alert('Mật khẩu không khớp!');</script>";
    } else {
        $hashed_password = password_hash($password, PASSWORD_DEFAULT);

        $sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        $stmt = $conn->prepare($sql);
        $stmt->bind_param("sss", $username, $hashed_password, $role);

        if ($stmt->execute()) {
            echo "<script>alert('Đăng ký thành công!'); window.location.href='login.php';</script>";
        } else {
            echo "<script>alert('Đăng ký thất bại: ' . $conn->error);</script>";
        }
        $stmt->close();
    }
}
$conn->close();
?>