export const dateUtil = {

  formatBR(date: any) {
    if (!date) return "";
    var m = new Date(date);
    var dataFormatado =
      ("0" + m.getUTCDate()).slice(-2) + "/" +
      ("0" + (m.getUTCMonth() + 1)).slice(-2) + "/" +
      String(m.getUTCFullYear()).substring(2, 4) + " " +
      ("0" + m.getUTCHours()).slice(-2) + ":" +
      ("0" + m.getUTCMinutes()).slice(-2) + ":" +
      ("0" + m.getUTCSeconds()).slice(-2);
    return dataFormatado;
  }
}
