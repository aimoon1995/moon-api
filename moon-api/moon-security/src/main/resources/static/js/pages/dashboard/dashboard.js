
function inti() {

    $.ajax({
        type: 'get',
        url: '/dashboard/getOpen',
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            barChart(data['blueArr'], data['redArr']);
        }
    });

    $.ajax({
        type: 'get',
        url: '/dashboard/diffHour',
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            lineChart(data['hxArr'], data['mtArr'], data['ddArr']);
        }
    });

    $.ajax({
        type: 'get',
        url: '/dashboard/moneyTotal',
        contentType: "application/json; charset=utf-8",
        success: function (data) {
            console.info(data);
            pieChart(data['list0'], data['list2']);
        }
    });

}


function pieChart(he_mt, t) {
    var myChart = echarts.init(document.getElementById('pie'));
    option = {
        title: {
            text: '开票金额统计'
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b}: {c} ({d}%)'
        },

        series: [
            {
                name: '',
                type: 'pie',
                selectedMode: 'single',
                radius: [0, '30%'],
                label: {
                    normal: {
                        show: true,
                        position: 'center',
                        formatter: function (argument) {
                            var html;
                            html = '总金额\r\n\r\n' + t[0].value;
                            return html;
                        },
                        textStyle: {
                            fontSize: 15,
                            color: '#FFFFFF'
                        }
                    },
                    position: 'inner',

                },
                labelLine: {
                    show: false
                },
                data: t //[{value: 9000000, name: '总金额'}]
            },
            {
                name: '数据来源和行',
                type: 'pie',
                radius: ['40%', '55%'],
                label: {
                    formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}',
                    backgroundColor: '#eee',
                    borderColor: '#aaa',
                    borderWidth: 1,
                    borderRadius: 4,
                    // shadowBlur:3,
                    // shadowOffsetX: 2,
                    // shadowOffsetY: 2,
                    // shadowColor: '#999',
                    // padding: [0, 7],
                    rich: {
                        a: {
                            color: '#999',
                            lineHeight: 22,
                            align: 'center'
                        },
                        // abg: {
                        //     backgroundColor: '#333',
                        //     width: '100%',
                        //     align: 'right',
                        //     height: 22,
                        //     borderRadius: [4, 4, 0, 0]
                        // },
                        hr: {
                            borderColor: '#aaa',
                            width: '100%',
                            borderWidth: 0.5,
                            height: 0
                        },
                        b: {
                            fontSize: 16,
                            lineHeight: 33
                        },
                        per: {
                            color: '#eee',
                            backgroundColor: '#334455',
                            padding: [2, 4],
                            borderRadius: 2
                        }
                    }
                },
                data: he_mt//[{value: 7000000, name: '和行金额'}, {value: 2000000, name: '美团金额'}]
            }
        ]
    };

    myChart.setOption(option);

}

function lineChart(hxArr, mtArr, ddArr) {
    var myChart = echarts.init(document.getElementById('line'));
    option = {
        title: {
            text: '分时统计'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['和行开票', '美团开票', '滴滴开票']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: ['0:00','01:00','02:00','03:00','04:00','05:00','06:00',
                '07:00','08:00','09:00','10:00','11:00','12:00','13:00',
                '14:00','15:00','16:00','17:00','18:00','19:00','20:00',
                '21:00','22:00','23:00']
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name: '和行开票',
                type: 'line',
                stack: '总量',
                data: hxArr //[120, 132, 101, 134, 90, 230, 210,120, 132, 101, 134, 90, 230, 210,120, 132, 101, 134, 90, 230, 210, 230, 210, 210]
            },

            {
                name: '美团开票',
                type: 'line',
                stack: '总量',
                data: mtArr //[150, 182, 191, 234, 290, 330, 310, 182, 191, 234, 290, 330, 310, 182, 191, 234, 290, 330, 310, 182, 191, 234, 210, 10]
            },

            {
                name: '滴滴开票',
                type: 'line',
                stack: '总量',
                data: ddArr //[150, 182, 191, 234, 290, 330, 310, 182, 191, 234, 290, 330, 310, 182, 191, 234, 290, 330, 310, 182, 191, 234, 210, 10]
            }

        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}


function barChart(b, r) {
    var myChart = echarts.init(document.getElementById('bar'));
    option = {
        title: {
            text: '开票数量统计',
            subtext: '数据来自和行'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        toolbox: {
            feature: {
                saveAsImage: {}
            }
        },
        legend: {
            data: ['开票', '作废']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'value',
            boundaryGap: [0, 0.01]
        },
        yAxis: {
            type: 'category',
            data: ['和行', '美团', '滴滴', '总计']
        },
        series: [
            {
                name: '开票',
                type: 'bar',
                data: b//[104970, 61744, 630230]
            },
            {
                name: '作废',
                type: 'bar',
                data: r//[1594, 134141, 681807]
            }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}
