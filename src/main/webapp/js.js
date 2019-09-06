/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var div = document.getElementById("div");
let url = "https://sinanjasar.dk/MovieRest/api/cinema/all";
    fetch(url)
            .then(res => res.json()) //in flow1, just do it
            .then(data => {
                // Inside this callback, and only here, the response data is available
                console.log("data", data);
                var head = "<tr><th>Name</th><th>Phone</th></tr>";
                data = data.map(obj => "<tr><td>" + obj.name + "</td><td>" + obj.phone + "</td></tr>");
                div.innerHTML = "<table>" + head.concat(data) + "</table>";

                // data.map(property => "<td>"+property+"</td>");
                /* data now contains the response, converted to JavaScript
                 Observe the output from the log-output above
                 Now, just build your DOM changes using the data*/
            });
        