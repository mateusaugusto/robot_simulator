function loadCanvasGRid(xd,yd, direction) {
    var c_canvas = document.getElementById("c");
    var context = c_canvas.getContext("2d");

    var background = new Image();
    background.src = "images/delete.png";

    for (var x = 0; x <= 600; x += 100 ) {
        context.moveTo(x, 0);
        context.lineTo(x, 600);

        context.lineWidth = 0;
        context.strokeStyle = "#000000";
        // Text value at that point
        context.font = '9px Arial';
        context.textAlign = 'start';
        context.fillText(x / 100, 1 * x + 40, 15);
    }

    for (var y = 0; y < 600; y += 100) {
        context.moveTo(0, y);
        context.lineTo(600, y);

        context.lineWidth = 0;
        context.strokeStyle = "#000000";
        // Text value at that point
        context.font = '9px Arial';
        context.textAlign = 'start';

        context.fillText(y /  100, 10, 1 * y + 30);
    }

    var background = new Image();
    background.src = "https://cdn4.iconfinder.com/data/icons/24x24-free-pixel-icons/24/Delete.png";

    background.onload = function() {
       // c_canvas.getContext('2d').drawImage(background, 1 * 100 - 60, 1 * 100 - 60);

        c_canvas.getContext('2d').drawImage(background, 440, 540);
    }

    context.strokeStyle = "#ddd";
    context.stroke();
}

loadCanvasGRid();

function test() {

    var test = {"commands":["POSITION 0 0 NORTH","FORWARD 1"]};

    $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/robot',
            contentType: 'application/json',
            data: JSON.stringify(test),
            dataType: 'html',
            complete: function (result) {
                //$cardBody.removeClass('isLoading');

            }
        }
    ).done(function (result) {
        var obj = JSON.parse(result);
        loadCanvasGRid(obj.grid.x, obj.grid.y, obj.direction);

    }).fail(function (err) {
        console.log(err);

    });

    return false;
}

//test();



