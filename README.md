# RelocateArray

### 이 코드는 잠시 백업하고자 올리는 코드로 387000 크기의 배열을 BMP특성에 맞게 바꾸기 위해 만든 것입니다.

### 받아온 바이트 배열에는 860 개의 연속된 색상 바이트가 150묶음으로 들어있으며, BMP 특성상 width와 height가 3의 배수가 되어야 하므로 마지막 1픽셀에는 0을 넣어 861 x 150으로 바꾸는 코드입니다.
