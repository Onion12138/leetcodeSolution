# 算法刷题篇

## 递归与回溯算法

### 专题1：排列问题

#### 例题1：全排列（46）

给定一个**没有重复**数字的序列，返回其所有可能的全排列。

```C++
class Solution {
public:
    vector<vector<int> > permute(vector<int> &num) {
        vector<vector<int> > res;
        permuteDFS(num, 0, res);
        return res;
    }
    void permuteDFS(vector<int> &num, int start, vector<vector<int> > &res) {
        if (start >= num.size()) res.push_back(num);
        for (int i = start; i < num.size(); ++i) {
            swap(num[start], num[i]);
            permuteDFS(num, start + 1, res);
            swap(num[start], num[i]);
        }
    }
};
```

```Java
class Solution {
    private ArrayList<List<Integer>> res;
    private boolean[]visited;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        visited = new boolean[nums.length];
        dfs(nums, new ArrayList<Integer>());
        return res;
    }
    private void dfs(int[] nums,ArrayList<Integer> temp){
        if(temp.size() == nums.length){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i] = true;
                temp.add(nums[i]);
                dfs(nums,temp);
                visited[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
```

#### 例题2：全排列2（47）

给定一个可包含重复数字的序列，返回所有不重复的全排列。

```C++
class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        visited=vector<bool>(nums.size(),false);
        vector<int>vec;
        getPermutation(nums,vec);
        return res;
    }
private:
    vector<vector<int>>res;
    vector<bool>visited;
    void getPermutation(vector<int>&nums,vector<int>&vec){
        if(vec.size()==nums.size()){
            res.push_back(vec);
            return;
        }
        for(int i=0;i<nums.size();i++){
            if(!visited[i]){
                if(i>0&&nums[i]==nums[i-1]&&!visited[i-1])
                    continue;
                visited[i]=true;
                vec.push_back(nums[i]);
                getPermutation(nums,vec);
                visited[i]=false;
                vec.pop_back();
            }
        }
        return;
    }
};
```

```Java
class Solution {
    private ArrayList<List<Integer>> res;
    private boolean []used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        used = new boolean[nums.length];
        dfs(nums, new ArrayList<Integer>());
        return res;
    }
    public void dfs(int []nums, ArrayList<Integer>temp){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                if(i>0 && nums[i]==nums[i-1]&&!used[i-1])
                    continue;
                used[i] = true;
                temp.add(nums[i]);
                dfs(nums, temp);
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
```

