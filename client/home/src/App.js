import { createTheme, Box } from "@mui/material";
import React, { useMemo } from "react";
import Grid from "./components/Grid.jsx";
import Container from "./components/Container.jsx";
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
  return (
    <div className="App">
      <Container>
        <Grid.Row>
          {[1, 2, 3, 4].map((i, j) => (
            <Grid.Col key={j} col={3}>
              <Box
                sx={{
                  height: "200px",
                  backgroundColor: "red",
                }}
              ></Box>
            </Grid.Col>
          ))}
        </Grid.Row>
      </Container>
    </div>
  );
}

export default App;
