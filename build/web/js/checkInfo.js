$(document).ready(function () {
    $("#submit").prop('disabled', true);
    var enabled = false;
    var enabledProductCode = false;
    var enabledDescription = false;
    var enabledPrice = false;
    var productCode = $('#productCode').val();

    if (productCode != "") {
        $('#productCode').change(function () {
            $('#productCode').val(productCode);
        });

        enabledProductCode = true;
        enabledDescription = true;
        enabledPrice = true;
        check();
    }

    function check() {
        if (!enabledProductCode || !enabledDescription || !enabledPrice) {
            enabled = false;
        } else {
            enabled = true;
        }

        if (enabled) {
            $("#submit").prop('disabled', false);
        } else {
            $("#submit").prop('disabled', true);
        }
    }
    ;

    $('#productCode').focusout(function () {
        if (isEmpty($(this))) {
            $('#productCodeFalse').text("Can't be empty!");
            enabledProductCode = false;
        } else {
            $('#productCodeFalse').text("");
            enabledProductCode = true;
        }
        check();
    });

    $('#productDescription').focusout(function () {
        if (isEmpty($(this))) {
            $('#productDescriptionFalse').text("Can't be empty!");
            enabledDescription = false;
        } else {
            $('#productDescriptionFalse').text("");
            enabledDescription = true;
        }
        check();
    });

    $('#productPrice').focusout(function () {
        if (isEmpty($(this))) {
            $('#productPriceFalse').text("Can't be empty!");
            enabledPrice = false;
        } else if (!isFloat($(this))) {
            $('#productPriceFalse').text("Price has to be a real number!");
            enabledPrice = false;
        } else {
            $('#productPriceFalse').text("");
            enabledPrice = true;
        }

        check();
    });

    function isEmpty(ob) {
        return ob.val() == "";
    }

    function isFloat(ob) {
        var count = 0;
        for (var i = 0; i < ob.val().length; i++) {
            if (ob.val().charAt(i) === '.') {
                count++;
            } else if (ob.val().charAt(i) < '0' || ob.val().charAt(i) > '9') {
                return false;
            }
        }

        if (count > 1) {
            return false;
        }

        return true;
    }
});
