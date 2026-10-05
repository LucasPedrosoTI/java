google.charts.load("current", { packages: ["corechart"], language: "pt-br" });
google.charts.setOnLoadCallback(drawChart);

function normalizarDatas(array) {
  return array.map((item) => {
    return [new Date(item[0]), item[1]];
  });
}

async function drawChart() {
  const baseUrl = window.location.origin;

  // Define the chart to be drawn.

  const response = await fetch(`${baseUrl}/wa/funcionarios/termino-wa`);
  const funcionarios = await response.json();

  if (funcionarios.length > 1) {
    const data = new google.visualization.DataTable();

    data.addColumn("date", "Data");
    data.addColumn("number", "Quantidade Funcionários");
    data.addRows(normalizarDatas(funcionarios));

    const options = {
      title: "Próximos Vencimentos de WA",
      legend: { position: "bottom" },
      vAxis: {
        format: "#",
        minValue: 0,
      },
      hAxis: {
        format: "dd/MM/yyyy",
        ticks: data.getDistinctValues(0),
        gridlines: {
          count: -1,
        },
      },
    };

    // Instantiate and draw the chart.
    const chart = new google.visualization.LineChart(
      document.getElementById("funcionarios-termino-wa")
    );

    chart.draw(data, options);
  }

  const responseVagas = await fetch(`${baseUrl}/wa/vagas/por-data`);
  const vagas = await responseVagas.json();

  if (vagas.length > 1) {
    const data2 = new google.visualization.DataTable();

    data2.addColumn("date", "Data");
    data2.addColumn("number", "Quantidade Vagas");
    data2.addRows(normalizarDatas(vagas));

    const options2 = {
      title: "Vagas Lançadas por Data",
      legend: { position: "bottom" },
      vAxis: {
        format: "#",
        minValue: 0,
      },
      hAxis: {
        format: "dd/MM/yyyy",
      },
    };

    const chart2 = new google.visualization.LineChart(
      document.getElementById("vagas")
    );

    chart2.draw(data2, options2);
  }
}
