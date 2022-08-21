import { Box } from "@mui/material";
import React from "react";

const DropDown = ({
  renderParent = () => <></>,
  renderChildren = () => <></>,
}) => {
  return (
    <Box
      sx={{
        position: "relative",
        cursor: "pointer",
        "&:hover": {
          "& .dropdown": {
            display: "block",
          },
        },
      }}
    >
      {renderParent()}
      <Box
        className="dropdown"
        sx={{
          minWidth: "200px",
          position: "absolute",
          backgroundColor: "white",
          boxShadow: "rgba(0, 0, 0, 0.35) 0px 5px 15px",
          right: 0,
          top: "100%",
          borderRadius: "5px",
          zIndex: 999999,
          display: "none",
        }}
      >
        {renderChildren()}
      </Box>
    </Box>
  );
};

export default DropDown;
