/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function c(val) {
    document.getElementById("display").value = val;
}
function math(val) {
    document.getElementById("display").value += val;
}
function e()
{
    try
    {
        c(eval(document.getElementById("display").value))
    } catch (e)
    {
        c('Error')
    }
}

//loads big buttons
function loadDocBig(url) {
    var head = document.getElementsByTagName('head')[0],
            link = document.createElement('link');
    link.type = 'text/css';
    link.rel = 'stylesheet';
    link.href = url;
    head.appendChild(link);
    return link;
}

//loads small buttons
function loadDocSmall(url) {
    var head = document.getElementsByTagName('head')[0],
            link = document.createElement('link');
    link.type = 'text/css';
    link.rel = 'stylesheet';
    link.href = url;
    head.appendChild(link);
    return link;
}

