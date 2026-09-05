<?php

use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});
use Illuminate\Support\Facades\Http;

Route::get('/productos-quarkus', function () {
    $response = Http::get('http://localhost:8080/productos');
    $productos = $response->json();

    return view('productos', compact('productos'));
});