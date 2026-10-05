$("#confirmacaoExclusaoModal").on("show.bs.modal", function (event) {
  const button = $(event.relatedTarget);

  const id = button.data("id");
  const nome = button.data("nome");

  const modal = $(this);
  const form = modal.find("form");

  let action = location.pathname;

  if (action.endsWith("/")) {
    action = action.substr(0, action.lastIndexOf("/"));
  }

  form.attr("action", `${action}/${id}`);

  modal
    .find(".modal-body span")
    .html("Tem certeza que deseja excluir <strong>" + nome + "</strong>?");
});

$(function () {
  $('[rel="tooltip"]').tooltip();
});

$("#pageSize").change(function () {
  let url = window.location.toString();

  if (url.includes("size")) {
    var indexSize = url.indexOf("size");
    var sizeSubstr = url.slice(indexSize - 1);
    url = url.replace(sizeSubstr, "");
  }

  if (url.includes("pageSize")) {
    var indexSize = url.indexOf("pageSize");
    var sizeSubstr = url.slice(indexSize - 1);
    url = url.replace(sizeSubstr, "");
  }

  if (url.includes("?")) {
    url = `${url}&size=${this.value}`;
  } else {
    url = `${url}?size=${this.value}`;
  }

  window.open(url, "_self");
});
