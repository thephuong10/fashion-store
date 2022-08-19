import React from "react";
import { Typography as TypographyCore } from "@mui/material";
import variables from "../styles/variables";

const STYLE_BY_SIZE = {
  xl: {
    fontSize: "30px",
    fontWeight: 700,
    lineHeight: 1.3,
  },
  l: {
    fontSize: "24px",
    fontWeight: 700,
    lineHeight: 1.4,
  },
  m: {
    fontSize: "20px",
    fontWeight: 700,
    lineHeight: 1.5,
  },
  s: {
    fontSize: "16px",
    fontWeight: 400,
    lineHeight: 1.5,
  },
  xs: {
    fontSize: "14px",
    fontWeight: 400,
    lineHeight: 1.43,
  },
};

const Typography = ({ children, sx = {}, color = "", size = "", ...rest }) => {
  const styleBySize = STYLE_BY_SIZE[size] || STYLE_BY_SIZE["s"];
  return (
    <TypographyCore
      sx={{
        ...styleBySize,
        color: color || variables.colors.text.primary,
        ...sx,
      }}
      {...rest}
    >
      {children}
    </TypographyCore>
  );
};

export default Typography;
