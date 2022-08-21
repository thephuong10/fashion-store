import {
  ListItem,
  AppBar,
  Box,
  IconButton,
  InputBase,
  List,
  Toolbar,
  Badge,
} from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";
import PersonOutlineIcon from "@mui/icons-material/PersonOutline";
import ArrowDropDownIcon from "@mui/icons-material/ArrowDropDown";
import ShoppingCartOutlinedIcon from "@mui/icons-material/ShoppingCartOutlined";
import React from "react";
import Container from "../components/Container";
import variables from "../styles/variables";
import logo from "../assets/logo.png";
import DropDown from "../components/DropDown";
import Typography from "../components/Typography";
// import { ReactComponent as Logo } from "../assets/logo.svg";
const Header = () => {
  return (
    <AppBar
      sx={{
        height: "100px",
        backgroundColor: variables.colors.pink.primary,
        boxShadow: "none",
      }}
    >
      <Container sx={{ height: "100%" }}>
        <Box
          sx={{
            display: "flex",
            alignItems: "center",
            justifyContent: "space-between",
            height: "100%",
          }}
        >
          <Box
            component="img"
            src={logo}
            sx={{ height: "80px", width: "150px" }}
          />
          <Box
            sx={{
              backgroundColor: "white",
              flex: "1",
              ml: "100px",
              height: "40px",
              display: "flex",
              borderRadius: "3px",
            }}
          >
            <InputBase
              placeholder="Tìm kiếm trong tên"
              sx={{
                height: "100%",
                flex: "1",
                padding: "5px 10px",
                border: "none",
                "& input": { padding: "0", outLine: 0 },
              }}
            />
            <Box
              sx={{
                backgroundColor: variables.colors.pink.dark,
                display: "flex",
                alignItems: "center",
                px: variables.spacing.s,
                cursor: "pointer",
                "&:hover": {
                  opacity: 0.9,
                },
              }}
            >
              <SearchIcon />
              <span>Tìm Kiếm</span>
            </Box>
          </Box>
          <Box
            sx={{
              ml: "100px",
              display: "flex",
              alignItems: "center",
              gap: "0 20px",
            }}
          >
            <DropDown
              renderParent={() => (
                <PersonOutlineIcon sx={{ width: "40px", height: "40px" }} />
              )}
              renderChildren={() => (
                <List>
                  {["Đăng Nhập", "Đăng Kí"].map((item) => (
                    <ListItem
                      key={item}
                      sx={{
                        "&:hover": {
                          "& *": {
                            color: variables.colors.pink.primary,
                          },
                        },
                        transition: "all 0.3s ease-in",
                      }}
                    >
                      <Typography>{item}</Typography>
                    </ListItem>
                  ))}
                </List>
              )}
            />
            <Badge
              badgeContent={4}
              sx={{
                "& .MuiBadge-badge": {
                  backgroundColor: variables.colors.info.primary,
                },
              }}
            >
              <ShoppingCartOutlinedIcon
                sx={{ width: "30px", height: "30px", cursor: "pointer" }}
              />
            </Badge>
          </Box>
        </Box>
      </Container>
    </AppBar>
  );
};
const Home = () => {
  return (
    <>
      <Header></Header>
    </>
  );
};

export default Home;
