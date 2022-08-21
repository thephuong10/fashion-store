import React from "react";
import { Grid as GridCore, Box } from "@mui/material";
import variables from "../styles/variables";
const Row = ({ children, sx = {} }) => {
  return (
    <GridCore
      container
      sx={{
        ...sx,
      }}
    >
      {children}
    </GridCore>
  );
};

const Col = ({
  children,
  col = 3,
  mdCol = 4,
  smCol = 6,
  xsCol = 12,
  sx = {},
}) => {
  return (
    <GridCore
      item
      lg={col}
      sm={smCol}
      xs={xsCol}
      md={mdCol}
      sx={{
        ...sx,
      }}
    >
      <Box
        sx={{
          p: variables.spacing.xs,
        }}
      >
        {children}
      </Box>
    </GridCore>
  );
};

const Grid = { Row, Col };

export default Grid;
