/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

//Cargar el contenido una vez que se haya cargado el documento HTML
window.addEventListener('load', () => {
    // Obteniendo el lienzo por Boujjou Achraf
    var c = document.getElementById("background");
    var ctx = c.getContext("2d");

    // Haciendo que el lienzo ocupe toda la pantalla
    c.height = window.innerHeight;
    c.width = window.innerWidth;

    // caracteres
    var matrix = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";

    var font_size = 10;
    var columns = c.width / font_size; // número de columnas para la lluvia
    // una matriz de gotas - una por cada columna
    var drops = [];
    // x es la coordenada x
    // 1 = coordenada y de la gota (igual para cada gota inicialmente)
    for (var x = 0; x < columns; x++) {
        drops[x] = 1;
    }

    // dibujando los caracteres
    function draw() {
        // Fondo blanco  para el lienzo
        // fondo translúcido para mostrar la estela
        ctx.fillStyle = "rgba(255, 255, 255, 0.04)";
        ctx.fillRect(0, 0, c.width, c.height);

        ctx.fillStyle = "#008f24"; // texto verde
        ctx.font = font_size + "px arial";


        for (var i = 0; i < drops.length; i++) {

            // Seleccionar un carácter aleatorio de "matrix" y dibujarlo en el canvas
            ctx.fillText(matrix[Math.floor(Math.random() * matrix.length)], i * font_size, drops[i] * font_size);

            // Si la gota ha cruzado el límite inferior del canvas, enviarla de vuelta a la parte superior de manera aleatoria
            if (drops[i] * font_size > c.height && Math.random() > 0.975) {
                drops[i] = 0;
            }

            // Incrementar la coordenada Y de la gota
            drops[i]++;
        }
    }

    setInterval(draw, 25);
});
