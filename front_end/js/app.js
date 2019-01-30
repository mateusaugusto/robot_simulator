var c_canvas;
var context;

function loadCanvasGRid(xd, yd, direction) {
    c_canvas = document.getElementById("c");
    context = c_canvas.getContext("2d");


    for (var x = 0; x <= 600; x += 100) {
        context.moveTo(x, 0);
        context.lineTo(x, 600);
        buildFillTextInGrid(context, x, 1 * x + 40, 25);
    }

    for (var y = 0; y <= 600; y += 100) {
        context.moveTo(0, y);
        context.lineTo(600, y);
        buildFillTextInGrid(context, y, 10, 1 * y + 30);
    }

    renderRobotInGrid(xd, yd, direction);

    context.strokeStyle = "#ddd";
    context.stroke();


}

function renderImageInGrid(gridPosition) {
    var plusPixelToRenderInCenter = 15;

    if (gridPosition === 0) {
        return plusPixelToRenderInCenter;
    }

    return (gridPosition * 100) + plusPixelToRenderInCenter;

}

function renderRobotInGrid(xd, yd, direction) {
    var background = new Image();
    background.src = "images/" + direction + ".png";
    background.onload = function () {
        c_canvas.getContext('2d').drawImage(background, renderImageInGrid(xd), renderImageInGrid(yd));
    }
}


function buildFillTextInGrid(context, grid, marginLeft, topMargin) {
    if (grid < 600) {
        context.fillText(grid / 100, marginLeft, topMargin);
    }
}

function resetCanvas() {
    context.clearRect(0, 0, 600, 600);
}


function buildResultInView(result) {
    var parsedData = JSON.parse(result.responseText);
    document.getElementById("grid").innerHTML = '(' + parsedData.grid.x + ',' + parsedData.grid.y + ')';
    document.getElementById("direction").innerHTML = parsedData.direction;
    var link = document.getElementById('result');
    link.style.display = 'block'; //or
}


function IsJsonString(str) {
    try {
        JSON.parse(str);
    } catch (e) {
        alert("json not valid")
        return false;
    }
    return true;
}

function sendScript(script) {
    if (!IsJsonString(script)) return false;

    resetCanvas();

    $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/robot',
            contentType: 'application/json',
            data: script,
            dataType: 'html',
            complete: function (result) {
                buildResultInView(result);
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

function init() {
    var script = {"commands": ["POSITION 1 3 EAST", "FORWARD 3", "RIGHT", "RIGHT", "FORWARD 1", "RIGHT", "FORWARD 2"]};
    document.getElementById("script").innerHTML = JSON.stringify(script, undefined, 2);
    //Default robot position
    loadCanvasGRid(0, 0, 'SOUTH');
}


init();




