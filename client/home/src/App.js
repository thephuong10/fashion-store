import { createTheme, Box } from "@mui/material";
import React, { useMemo } from "react";
import Grid from "./components/Grid.jsx";
import Container from "./components/Container.jsx";
import variables from "./styles/variables.js";
import Home from "./layouts/Home.jsx";
function App() {
  variables.theme = useMemo(
    () =>
      createTheme({
        breakpoints: {
          values: variables.breakPoints,
        },
      }),
    []
  );
  return (
    <div className="App">
      <Home />
    </div>
  );
}

export default App;
