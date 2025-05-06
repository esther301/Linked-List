@RestController
@RequestMapping("/api/arrays")
public class ArrayController {

    @Autowired
    private ArrayService arrayService;

    // 1D Array endpoint
    @PostMapping("/temperature")
    public ResponseEntity<?> analyzeTemperatures(@RequestBody double[] temperatures) {
        try {
            return ResponseEntity.ok(arrayService.analyzeTemperatures(temperatures));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 2D Array endpoint
    @PostMapping("/transpose")
    public int[][] transposeMatrix(@RequestBody int[][] matrix) {

        return arrayService.transposeMatrix(matrix);
    }
}
