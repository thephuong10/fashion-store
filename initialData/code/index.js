const getPrice = (price) => {
  let priceString = price.toString();
  return parseInt(priceString.substring(0, priceString.length - 5));
};

const isArray = (arr) => Array.isArray(arr) && arr.length;

const getUrlImage = (file) => `https://cf.shopee.vn/file/${file}`;

const result = fakeData.slice(1, 20).map(({ item_basic }) => {
  let colors = item_basic?.tier_variations.find(
    (i) =>
      i.name.toLowerCase().includes("màu") ||
      i.name.toLowerCase().includes("phân loại")
  );
  let sizes = item_basic?.tier_variations.find((i) =>
    i.name.toLowerCase().includes("size")
  );

  let images = colors?.images || [];

  let variants = [];
  let models = [];

  if (isArray(images)) {
    if (isArray(colors?.options)) {
      variants.push({
        options: colors.options,
        images: images.map((i) => getUrlImage(i)),
        name: colors.name,
        type: "color",
      });
    }
    if (isArray(sizes?.options)) {
      variants.push({
        options: sizes.options,
        name: colors.name,
        type: "size",
      });
    }
    if (isArray(colors?.options) && isArray(sizes?.options)) {
      for (let i = 0; i < colors?.options?.length; i++) {
        for (let j = 0; j < sizes?.options?.length; j++) {
          models.push({
            name: `${colors.options[i]} , ${sizes.options[j]}`,
            variantIndex: [i, j],
            priceOriginal: getPrice(item_basic.price),
            quantity: (i + j) * 11,
          });
        }
      }
    } else {
      const _options = colors?.options || sizes?.options || [];
      for (let j = 0; j < _options.length; j++) {
        models.push({
          name: _options[j],
          variantIndex: [j],
          priceOriginal: getPrice(item_basic.price),
          quantity: (1 + j) * 11,
        });
      }
    }
    return {
      name: item_basic.name,
      avatar: getUrlImage(item_basic.image),
      variants: variants,
      models: models,
    };
  }

  return {
    name: item_basic.name,
    avatar: getUrlImage(item_basic.image),
    variants: [],
    models: [],
    priceOriginal: getPrice(item_basic.price),
    quantity: 20,
  };
});

console.log(JSON.stringify(result));

// const _categories = [...categories];

// const createTree = (elm) => {
//   const childrens = _categories.filter(
//     (c) =>
//       c.parentsId.length === elm.parentsId.length + 1 &&
//       c.parentsId.some((cc) => cc === elm.id)
//   );
//   elm.children = [];
//   if (childrens.length) {
//     elm.children = [...childrens];
//     childrens.forEach((c) => {
//       createTree(c);
//     });
//   }
// };

// _categories.filter((c) => !c.parentsId.length).forEach((c) => createTree(c));

// console.log(JSON.stringify(_categories.filter((c) => !c.parentsId.length)));
