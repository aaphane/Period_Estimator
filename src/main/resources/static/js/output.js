var getDateArray = function(start, end) {
    var arr = new Array();
    var dt = new Date(start);

    while (dt <= end) {
        arr[ new Date( dt )] = new Date( dt );
        dt.setDate(dt.getDate() + 1);
    }
    return arr;
}

var  getDate = function(start) {
    var st = start.split("/");
    start = st[1] + "/" + st[0] + "/" + st[2];
    return(start);
}

$( function() {
    var nextPer = document.getElementById("NextPeriod").innerHTML;
    var mostFert = document.getElementById("MostFert").innerHTML;
    var start = document.getElementById("PerStart").innerHTML;
    var end = document.getElementById("PerEnd").innerHTML;
    var startDatePeriod = new Date( getDate(start) );
    var endDatePeriod = new Date( getDate(end) );
    var most = new Date(getDate(mostFert))
    var next = new Date(getDate(nextPer));
    var periods = getDateArray(startDatePeriod, endDatePeriod);
    var start = document.getElementById("OvuStart").innerHTML;
    var end = document.getElementById("OvuEnd").innerHTML;
    var startDateOvu = new Date( getDate(start) );
    var endDateOvu = new Date( getDate(end) );
    var ovulation = getDateArray(startDateOvu, endDateOvu);
    delete ovulation[most];
    var mostFert = getDateArray(most, most) 
    var nextPer = getDateArray(next, next)
    $('#datepicker1').datepicker({
        dateFormat: 'dd/mm/yy',
        beforeShowDay: function( date ) {
            var highlightFertile = mostFert[date]
            var highlightPeriod = periods[date];
            var highlightNextPeriod = nextPer[date];
            var highlightOvulation = ovulation[date];
            if( highlightPeriod ) {
                 return [true, "event2", 'Your Period'];
            }
            else if(highlightOvulation){
                return [true, "event", 'Ovulation'];
            }
            else if(highlightFertile){
                return [true, "event3", 'Most Fertile Day'];
            }
            else if(highlightNextPeriod){
                return [true, "event2", 'Next Period Start Day'];
            }
            else {
                 return [true, '', ''];
            }
        }
    });
});