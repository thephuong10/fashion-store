import React from "react";
import { Box } from "@mui/material";
import variables from "../styles/variables";

const calcMaxWidth = (num, p = 0) => `${num - p}px`;

const Container = ({ children, sx = {}, ...rest }) => {
  return (
    <Box
      sx={{
        ml: "auto",
        mr: "auto",
        width: "100%",
        [variables.theme.breakpoints.down("xxl")]: {
          maxWidth: "1140px",
        },
        [variables.theme.breakpoints.down("xl")]: {
          maxWidth: "1040px",
        },
        [variables.theme.breakpoints.down("lg")]: {
          maxWidth: "960px",
          pl: "8px",
          pr: "8px",
        },
        [variables.theme.breakpoints.down("md")]: {
          maxWidth: "740px",
          pl: "10px",
          pr: "10px",
        },
        [variables.theme.breakpoints.down("sm")]: {
          maxWidth: "540px",
          pl: "10px",
          pr: "10px",
        },
        ...sx,
      }}
      {...rest}
    >
      {children}
    </Box>
  );
};

export default Container;
