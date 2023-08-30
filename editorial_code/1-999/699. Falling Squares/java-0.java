Set<Integer> coords = new HashSet();
for (int[] pos: positions) {
    coords.add(pos[0]);
    coords.add(pos[0] + pos[1] - 1);
}
List<Integer> sortedCoords = new ArrayList(coords);
Collections.sort(sortedCoords);

Map<Integer, Integer> index = new HashMap();
int t = 0;
for (int coord: sortedCoords) index.put(coord, t++);