//获取Ajax的核心对象 XMLHttpRequest
/*
 function getXMLHttpRequest() {
 var xhr;
 if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
 xhr = new XMLHttpRequest();
 } else {// code for IE6, IE5
 xhr = new ActiveXObject("Microsoft.XMLHTTP");
 }
 return xhr;
 }
 */
function getXMLHttpRequest() {
    var xmlHttp;

    try {
        // Firefox, Opera 8.0+, Safari
        xmlHttp = new XMLHttpRequest();
    } catch (e) {
        // Internet Explorer
        try {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                alert("您的浏览器不支持AJAX！");
                return false;
            }
        }
    }
    return xmlHttp;

}
