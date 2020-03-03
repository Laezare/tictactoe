<template>
  <div>
    <h1>Tic Tac Toe App</h1>
    <p>Joueur 1 est O, score: {{ScoreJ1}} &emsp; Joueur 2 est X, score: {{ScoreJ2}}</p>
    <center>
      <table>
        <tr v-for="(row, idx1) in Grid" v-bind:key="(row, idx1)">
          <td v-for="(col, idx2) in row" v-bind:key="(col, idx2) in row">
            <div style="text-align:center">
              <button v-on:click="updateGrid(idx1,idx2)" class="case btn-sm">
                <h1>{{Grid[idx1][idx2]}}</h1>
              </button>
            </div>
          </td>
        </tr>
      </table>
    </center>
    <p>Compteur: {{count}}</p>
    <button v-on:click="reset()" class="reset btn-sm btn-danger">Reset</button>
  </div>
</template>


<script>
export default {
  data() {
    return {
      Grid: [
        [" ", " ", " "],
        [" ", " ", " "],
        [" ", " ", " "]
      ],
      count: 0,
      ScoreJ1: 0,
      ScoreJ2: 0
    };
  },
  mounted() {
    if (localStorage.count) {
      this.count = localStorage.count;
    }
  },
  methods: {
    checkCase(x, y, v) {
      if (x < 0 || x > 2 || y < 0 || y > 2) {
        return false;
      } else if (this.Grid[x][y] == v) {
        return true;
      } else {
        return false;
      }
    },
    checkVictoryConditions(x, y, v) {
      if (
        (this.checkCase(x, y + 1, v) &&
          this.checkCase(x, y + 2, v)) /* vertical droite */ ||
        (this.checkCase(x, y - 1, v) &&
          this.checkCase(x, y - 2, v)) /* vertical gauche */ ||
        (this.checkCase(x + 1, y, v) &&
          this.checkCase(x + 2, y, v)) /* horizontal haut */ ||
        (this.checkCase(x - 1, y, v) &&
          this.checkCase(x - 2, y, v)) /* horizontal bas */ ||
        (this.checkCase(x + 1, y + 1, v) &&
          this.checkCase(x + 2, y + 2, v)) /* diag hg bd */ ||
        (this.checkCase(x + 1, y - 1, v) &&
          this.checkCase(x + 2, y - 2, v)) /* diag bg hd */ ||
        (this.checkCase(x - 1, y + 1, v) &&
          this.checkCase(x - 2, y + 2, v)) /* diag hd bg */ ||
        (this.checkCase(x - 1, y - 1, v) &&
          this.checkCase(x, y - 2, v)) /* diag bd hg */ ||
        (this.checkCase(x - 1, y - 1, v) &&
          this.checkCase(x - 2, y - 2, v)) /* mid vertical */ ||
        (this.checkCase(x, y - 1, v) &&
          this.checkCase(x, y + 1, v)) /* mid horizontal */ ||
        (this.checkCase(x - 1, y + 1, v) &&
          this.checkCase(x + 1, y - 1, v)) /* mid diag */ ||
        (this.checkCase(x - 1, y - 1, v) &&
          this.checkCase(x + 1, y + 1, v)) /* mid diag */
      ) {
        if (v == "O") {
          this.ScoreJ1 += 1;
          if (this.ScoreJ1 == 3) {
            alert("Joueur 1 a gagné");
            this.ScoreJ1 = 0;
            this.ScoreJ2 = 0;
            setTimeout(this.reset(), 5000);
          } else {
            alert("Joueur 1 a remporté la manche");
            setTimeout(this.reset(), 5000);
          }
        } else {
          this.ScoreJ2 += 1;
          if (this.ScoreJ2 == 3) {
            alert("Joueur 2 a gagné");
            this.ScoreJ1 = 0;
            this.ScoreJ2 = 0;
            setTimeout(this.reset(), 5000);
          } else {
            alert("Joueur 2 a remporté la manche");
            setTimeout(this.reset(), 5000);
          }
        }
      }
    },
    updateGrid(x, y) {
      if (this.Grid[x][y] == " " && this.count % 2 == 0) {
        (this.Grid[x][y] = "O"), this.checkVictoryConditions(x, y, "O");
      } else if (this.Grid[x][y] == " ") {
        (this.Grid[x][y] = "X"), this.checkVictoryConditions(x, y, "X");
      } else {
        this.count -= 1;
      }
      this.count += 1;
    },
    reset() {
      (this.Grid = [
        [" ", " ", " "],
        [" ", " ", " "],
        [" ", " ", " "]
      ]),
        (this.count = 0);
    }
  }
};
</script>

<style scoped>
table {
  border-collapse: collapse;
  text-align: center;
}
td {
  width: 10em;
  height: 10em;
}
.case {
  width: 11em;
  height: 11em;
  background-color: grey;
}
</style>