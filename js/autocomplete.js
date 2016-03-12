/*
 * autocomplete.js
 *
 * Provides AJAX autocompletion for search form.
 * Borrowed from CIS419 course materials, Session 9, ajax-my-app
 *
 * Northwestern University
 * CIS 419 Web Application Development, Winter 2016
 * Final Project
 *
 * March 13, 2016
 *
 * Mike Molenda
 * michaelmolenda2014@u.northwestern.edu 
 */

var xhttp = new XMLHttpRequest();    // XMLHttpRequest object
var completeField;      // ID of field to autocomplete
var completeTable;      // ID of table in which to return data

/**
 * Gets elements from DOM.
 */
function init() {
    completeField = document.getElementById("complete-field");
    completeTable = document.getElementById("complete-table");
}

/**
 * Primary autocomplete operation.
 * Sets up and sends XML request to AutoComplete servlet.
 */
function doCompletion() {
    // Set URL for autocompletion (with HTTP special chars)
    var url = "AutoComplete?action=complete&id=" 
            + encodeURIComponent(completeField.value);

    // Set XMLHttpRequest method, URL, and async
    xhttp.open("GET", url, true);

    // Assign callback function to be called every time the state changes
    xhttp.onreadystatechange = callback;

    xhttp.send();
}

/**
 * Callback function to be performed on state changes in doCompletion.
 * Checks if XML response has been received, and if so, processes it.
 */
function callback() {
    // Clear all completeTable rows
    clearTable();

    // If XML response ready and status OK, process it
    if (xhttp.readyState == 4) {
        if (xhttp.status == 200) {
            parseMessages(xhttp.responseXML);
        }
    }
}

/**
 * Removes all rows from completeTable.
 * Used to "refresh" results on every state change.
 */
function clearTable() {

    if (completeTable.getElementsByTagName("tr").length > 0) {
        // If completeTable has rows, hide table, then remove them
        completeTable.style.display = 'none';
        for (i = completeTable.childNodes.length - 1; i >= 0; i--) {
            completeTable.removeChild(completeTable.childNodes[i]);
        }
    }
}

/**
 * Processes XML response from AutoComplete servlet.
 * Reads XML nodes, and passes their data to appendItem method.
 */
function parseMessages(responseXML) {
    // No matches returned
    if (responseXML == null) {
        return false;
    } else {
        // Get "items" node from response XML. 
        // [0] used b/c getElementsByName returns an array.
        var items = responseXML.getElementsByTagName("items")[0];

        // Pass data from each child node ("item") in items to appendItem
        if (items.childNodes.length > 0) {
            for (i = 0; i < items.childNodes.length; i++) {

                var item = items.childNodes[i];

                var name = item.getElementsByTagName("name")[0];
                var nameValue = name.childNodes[0].nodeValue;

                var itemId = item.getElementsByTagName("id")[0];
                var itemIdValue = itemId.childNodes[0].nodeValue;

                appendItem(itemIdValue, nameValue);
            }
        }
    }
}

/**
 * Appends each item returned by response XML to completeTable
 */
function appendItem(itemId, name) {

    var tr;
    var td;
    var anchor;     // "lookup" action link

    completeTable.style.display = 'table-row-group';
    tr = document.createElement("tr");
    td = document.createElement("td");
    tr.appendChild(td);
    completeTable.appendChild(tr);
    td.className = "popupCell";         // Adds CSS style

    anchor = document.createElement("a");
    //anchor.className = "popupItem"      // Adds CSS style
    anchor.setAttribute("href", "AutoComplete?action=lookup&id=" + itemId);
    anchor.appendChild(document.createTextNode(name));
    td.appendChild(anchor);
}