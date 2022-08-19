import { createTheme } from "@mui/material";
import React, { useMemo } from "react";
import variables from "./styles/variables.js";
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
  return <div className="App"></div>;
}

export default App;
